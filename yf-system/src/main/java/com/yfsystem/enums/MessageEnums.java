package com.yfsystem.enums;

public enum MessageEnums {

    LoginSuccess("登录成功", "2000"),
    ParseTokenSuccess("解析Token成功", "20001"),
    RegisterSuccess("注册成功", "20002"),
    ParseTokenError("解析Token失败", "50005"),
    TokenIsNull("token为空", "50004"),
    LoginErrorByUserNameOrPassword("用户名或者密码错误", "50001"),
    LoginAgain("请重新登录", "50002"),
    RegisterError("用户名已存在", "50003");

    private final String message;
    private final String code;

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    MessageEnums(String message, String code) {
        this.message = message;
        this.code = code;
    }

}
