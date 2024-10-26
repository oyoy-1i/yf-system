package com.yfsystem.exceptions;

import com.yfsystem.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName GlobalExceptionHandler
 * Author OuYangYiFan
 * Description TODO
 * DATA 2024/10/22 下午10:37
 * Version 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(YfSystemException.class)
    public Result handleYfSystemException(YfSystemException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

}
