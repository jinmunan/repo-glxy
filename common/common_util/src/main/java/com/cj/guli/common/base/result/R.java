package com.cj.guli.common.base.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 响应返回结果
 * @since 2019/12/25
 */
@Data
@ApiModel(value = "全局统一返回结果")
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    public R(){}

    // 成功
    public static R ok(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    // 失败
    public static R error(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return r;
    }

    // 设置枚举的返回类型
    public static R setResult(ResultCodeEnum resultCodeEnum){
        R r = new R();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }

    // 单纯的设置
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    // 单纯的设置
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    // 单纯的设置
    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    // 键和值设置到hashmap中
    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    // 直接传入一个hashmap
    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
