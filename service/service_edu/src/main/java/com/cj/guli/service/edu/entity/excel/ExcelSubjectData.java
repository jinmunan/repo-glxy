package com.cj.guli.service.edu.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @author： jinmunan
 * @date： 2022-07-01 14:59
 */
@Data
public class ExcelSubjectData {
    @ExcelProperty(value = "一级分类")
    private String levelOneTitle;

    @ExcelProperty(value = "二级分类")
    private String levelTwoTitle;
}
