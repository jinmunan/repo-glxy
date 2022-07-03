package com.cj.easyexcel.dao;

import com.cj.easyexcel.entity.ExcelStudentData;

import java.util.List;

/**
 * @version 1.0
 * @author： jinmunan
 * @date： 2022-07-01 11:15
 */
public class ExcelStudentDataDAO {
    public void save(List<ExcelStudentData> cachedDataList) {
        //insert into 数据库中
        cachedDataList.forEach(System.out::println);
    }
}
