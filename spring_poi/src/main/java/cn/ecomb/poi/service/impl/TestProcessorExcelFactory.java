package cn.ecomb.poi.service.impl;

import cn.ecomb.poi.controller.dto.BookDTO;
import cn.ecomb.poi.service.ProcessorExcelFactory;
import cn.ecomb.poi.utils.ExtractZip;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhouzhigang
 * @date 2018/4/8.
 */
public class TestProcessorExcelFactory implements ProcessorExcelFactory<BookDTO>{

    /**
     * 除了一般的解析方案，还提供压缩包的解析方案：
     * excel 和相关文件压缩成 zip 包
     * 数据在 excel 里面进行关联
     * @param ZipPath
     * @return
     */
    public List<BookDTO> resolverByZIPSchema(String ZipPath) {
        List<BookDTO> bookDTOList = new ArrayList<>();
        try {
            List<String> names = ExtractZip.unZip("/tmp/excel.zip", "/tmp");
            // 找出excel文件
            List<String> excelName = findExcelNames(names);
            TestProcessorExcelFactory processorExcelFactory = new TestProcessorExcelFactory();
            bookDTOList = processorExcelFactory.resolver(excelName.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookDTOList;
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


    public List<BookDTO> resolver(String excelFilePath) {
        try {
            Workbook workbook = this.getWorkBook(excelFilePath);
            resolver(workbook);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BookDTO> resolver(Workbook workbook) throws Exception {
        List<BookDTO> bookDTOList = new ArrayList<>();
        if (workbook.getSheetAt(0).getLastRowNum() == 0) {
            throw new Exception("Excel 文件没有数据");
        }

        for (int i = 0, numberOfSheets = workbook.getNumberOfSheets(); i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            for (int j = 1, numberOfRows = sheet.getLastRowNum(); j < numberOfRows+1; j++) {
                resolverRow(sheet.getRow(j));
            }
        }
        return null;
    }


    /**
     * 这个解析到具体列的方法，可以使用回调函数，将处理过程抛出去
     * @param row
     * @return
     */
    private BookDTO resolverRow(Row row) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName(getCellValue(row.getCell(0)));
        bookDTO.setNumber(Integer.parseInt(getCellValue(row.createCell(1))));
        //todo 处理图片，获取解压后的zip包中的图片，上传图片，纪录bookDTO中返回的文件ID
        bookDTO.setPhotoUrl(getCellValue(row.getCell(2)));
        return bookDTO;
    }

    @Override
    public Workbook create(List<BookDTO> data) {

        return null;
    }

    @Override
    public void setTemplate(Map<String, String> templateMap) {

    }

    @Override
    public Workbook createTemplate(Map<String, String> templateMap) {
        return null;
    }
}
