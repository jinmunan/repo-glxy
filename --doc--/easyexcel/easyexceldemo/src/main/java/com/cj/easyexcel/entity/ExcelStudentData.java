package com.cj.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @author： jinmunan
 * @date： 2022-07-01 10:25
 */
@Data
public class ExcelStudentData {


    @ExcelProperty(value = "姓名")
    private String name;

    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty(value = "生日")
    private Date birthday;

    @NumberFormat("#.##%")//百分比表示，保留两位小数
    @ExcelProperty(value = "薪资")
    private Double salary;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String password;
}