package com.cj.easyexcel;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.cj.easyexcel.entity.ExcelStudentData;
import com.cj.easyexcel.listener.ExcelStudentDataListener;
import org.junit.Test;

/**
 * @version 1.0
 * @author： jinmunan
 * @date： 2022-07-01 10:59
 */
public class ExcelReadTest {

    /**
     * 最简单的读
     */
    @Test
    public void simpleRead07() {

        String fileName = "d:/excel/01-simpleWrite-07.xlsx";
        // 这里默认读取第一个sheet
        EasyExcel.read(fileName, ExcelStudentData.class, new ExcelStudentDataListener()).sheet("模板").doRead();
    }

    @Test
    public void simpleRead03() {

        String fileName = "d:/excel/01-simpleWrite-03.xls";
        // 这里默认读取第一个sheet
        EasyExcel.read(fileName, ExcelStudentData.class, new ExcelStudentDataListener()).excelType(ExcelTypeEnum.XLS).sheet("模板").doRead();
    }
}