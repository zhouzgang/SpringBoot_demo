package cn.ecomb.poi.controller;

import cn.ecomb.poi.controller.dto.BookDTO;
import cn.ecomb.poi.service.ProcessorExcelFactory;
import cn.ecomb.poi.service.impl.TestProcessorExcelFactory;
import cn.ecomb.poi.utils.ExtractZip;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/3/29.
 */
@RestController
public class FileController {

    @PostMapping("/file/uploads")
    public void upload(@RequestParam("upload_files") MultipartFile[] uploadingFiles) throws IOException {

        for(MultipartFile uploadedFile : uploadingFiles) {
            File file = new File("/" + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
        }
    }


    @PostMapping("/file/upload")
    public void upload(@RequestParam MultipartFile multipartFile) throws IOException {

        if(multipartFile.isEmpty()){
            return;
        }

        File file = new File("/tmp/" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);

        try {
            List<String> names = ExtractZip.unZip("/tmp/excel.zip", "/tmp");
            // 找出excel文件
            List<String> excelName = findExcelNames(names);
            TestProcessorExcelFactory processorExcelFactory = new TestProcessorExcelFactory();
            List<BookDTO> bookDTOList = processorExcelFactory.resolver(excelName.get(0));
            doservice(bookDTOList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doservice(List<BookDTO> list) {

    }

    private List<String> findExcelNames(List<String> names) {
        List<String> excelName = new ArrayList<>();
        for (String name: names) {
            if (StringUtils.startsWith(name, "excel") && StringUtils.endsWith(name, "xlsx")) {
                excelName.add(name);
            }
        }
        return excelName;
    }


    public static void main(String[] args) throws IOException {
        File file = new File("README.md");
        InputStream inputStream = new FileInputStream(file);
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            String s = new String(bytes);
            stringBuffer.append(s);
        }
        System.out.println(stringBuffer);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }


}
