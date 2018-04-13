package cn.ecomb.poi.service;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhouzhigang
 * @date 2018/4/8.
 * <p>
 * 解析excel工厂方法接口
 */
public interface ProcessorExcelFactory<T> {

    String EXCEL_TYPE_XLS = "xls";
    String EXCEL_TYPE_XLSX = "xlsx";

    /**
     * 解析 excel 数据成 list
     *
     * @return
     */
    List<T> resolver(Workbook workbook) throws Exception;

    /**
     * 将 list 中数据分装至 excel 的 Workbook 中
     * excel 模版的定义，导出excel的文件名
     * @param data
     * @return
     */
    Workbook create(List<T> data);

    /**
     * 设置生成的模版
     * @param templateMap
     */
    void setTemplate(Map<String, String> templateMap);

    /**
     * 创建excel模版
     * @param templateMap
     * @return
     */
    Workbook createTemplate(Map<String, String> templateMap);

    /**
     * 更具不同的 excel 版本，构建不同的 Workbook
     * @param excelFilePath
     * @return
     * @throws Exception
     */
    default Workbook getWorkBook(String excelFilePath) throws Exception {
        Workbook workbook = null;
        //todo 这里 流  没有关闭
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
        if (excelFilePath.toLowerCase().endsWith(EXCEL_TYPE_XLS)) {
            workbook = new HSSFWorkbook(fileInputStream);
        } else if (excelFilePath.toLowerCase().endsWith(EXCEL_TYPE_XLSX)) {
            workbook = new XSSFWorkbook(fileInputStream);
        } else {
            throw new Exception("文件不是Excel文件。");
        }
        return workbook;
    }

    /**
     * 获取列中的数据
     * @param cell
     * @return
     */
    default String getCellValue(Cell cell) {
        String value = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                    value = cell.getNumericCellValue() + "";
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        if (date != null) {
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        }
                    } else {
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_FORMULA:
                    value = cell.getCellFormula().toString();
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    value = "";
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR:
                    value = "非法字符串";
                    break;
                default:
                    value = "未知字符";
                    break;
            }
        }
        return value.trim();
    }

}




























