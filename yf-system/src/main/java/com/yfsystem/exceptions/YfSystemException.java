package com.yfsystem.exceptions;

import com.yfsystem.enums.MessageEnums;

/**
 * ClassName YfSystemException
 * Author OuYangYiFan
 * Description TODO
 * DATA 2024/10/22 下午10:38
 * Version 1.0
 */

public class YfSystemException extends RuntimeException {

    private String message;
    private String code;

    public YfSystemException(MessageEnums enums) {
        this.message = enums.getMessage();
        this.code = enums.getCode();
    }


    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
