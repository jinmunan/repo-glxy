package com.cj.guli.service.base.handler;


import com.cj.guli.common.base.result.R;
import com.cj.guli.common.base.result.ResultCodeEnum;
import com.cj.guli.common.base.util.ExceptionUtils;
import com.cj.guli.service.base.exception.GuliException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理器
 * @author jinmunan
 * @since 2020/4/1
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        // 打印不到日志文件中
        //e.printStackTrace();
        // 打印到日志文件中
        log.error(ExceptionUtils.getMessage(e));
        return R.error();
    }

    // 捕获特定的异常
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e) {
        log.error(ExceptionUtils.getMessage(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    // 捕获特定的异常
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(HttpMessageNotReadableException e) {
        log.error(ExceptionUtils.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    // 捕获自定义异常
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
