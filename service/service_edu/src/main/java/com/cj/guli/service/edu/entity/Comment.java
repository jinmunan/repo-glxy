package com.cj.guli.service.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cj.guli.service.base.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("edu_comment")
@ApiModel(value="Comment对象", description="评论")
public class Comment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程id")
    private String courseId;

    @ApiModelProperty(value = "讲师id")
    private String teacherId;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员昵称")
    private String nickname;

    @ApiModelProperty(value = "会员头像")
    private String avatar;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
