package cn.ecomb.poi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
        System.out.println(file.getAbsolutePath());
        multipartFile.transferTo(file);
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
