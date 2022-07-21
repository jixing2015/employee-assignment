package com.sw.basis.utils.exception;

import com.sw.basis.utils.Responses;
import com.sw.basis.utils.enums.ResultCode;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常
 * @author jixing2000
 * @date 2022/7/21 0021 16:55:40
 **/
@RestControllerAdvice
public class GlobalException {

    /**
     * 参数异常捕获
     * @param e 异常
     *
     * @return 提示
     **/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Responses MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return Responses.error(ResultCode.REQ_PARAMS_ERROR.code,objectError.getDefaultMessage());
    }

    /**
     * 自定义异常捕获
     * @param e 异常
     *
     * @return 提示
     **/
    @ExceptionHandler(MyException.class)
    public Responses APIExceptionHandler(MyException e) {
        return Responses.error(e.getCode(),e.getMessage());
    }
}
