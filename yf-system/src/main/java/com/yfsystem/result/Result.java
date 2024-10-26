package com.yfsystem.result;

import com.yfsystem.enums.MessageEnums;

/**
 * ClassName Result
 * Author OuYangYiFan
 * Description TODO
 * DATA 2024/10/22 下午10:44
 * Version 1.0
 */
public class Result<T> {

    private String code;
    private T data;
    private String msg;

    public Result(MessageEnums enums, T data) {
        this.code = enums.getCode();
        this.data = data;
        this.msg = enums.getMessage();
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> Result<T> ok(MessageEnums enums, T data) {
        return new Result<T>(enums, data);
    }

    public static <T> Result<T> error(String code,String msg) {
        return new Result<>(code, msg);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
