package com.cj.guli.service.base.exception;

import com.cj.guli.common.base.result.ResultCodeEnum;
import lombok.Data;

/**
 * @version 1.0
 * @author： jinmunan
 * @date： 2022-06-27 10:49
 */
@Data
public class GuliException extends RuntimeException {
    //状态码
    private Integer code;

    /**
     * 接受状态码和消息
     * 枚举没有定义的
     *
     * @param code
     * @param message
     */
    public GuliException(String message, Integer code) {
        // 调用父类的构造器
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型
     * 枚举定义好的
     *
     * @param resultCodeEnum
     */
    public GuliException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
