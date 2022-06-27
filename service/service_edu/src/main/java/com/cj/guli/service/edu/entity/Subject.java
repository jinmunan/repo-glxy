package com.cj.guli.service.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cj.guli.service.base.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课程科目
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("edu_subject")
@ApiModel(value="Subject对象", description="课程科目")
public class Subject extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类别名称")
    private String title;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;


}
