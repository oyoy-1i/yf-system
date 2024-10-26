package com.yfsystem.controller;


import com.yfsystem.enums.MessageEnums;
import com.yfsystem.mappers.UsersMapper;
import com.yfsystem.pojo.User;
import com.yfsystem.result.Result;
import com.yfsystem.service.LoginService;
import com.yfsystem.utils.JWTUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

import static com.yfsystem.result.Result.ok;

/**
 * ClassName LoginController
 * Author OuYangYiFan
 * Description TODO
 * DATA 2024/10/22 下午5:32
 * Version 1.0
 */
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public Result login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpServletResponse response,
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String token = loginService.login(username, password);
        response.setHeader("Authorization", token);
        return Result.ok(MessageEnums.LoginSuccess,token);
    }

    @RequestMapping(value = "/parseToken", method = RequestMethod.POST)
    public Result parseToken(HttpServletRequest request, User user) throws UnsupportedEncodingException {
        String authType = request.getHeader("Authorization");
        User userInfo = loginService.getUserInfo(authType);
        return Result.ok(MessageEnums.ParseTokenSuccess, userInfo);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(@RequestBody User user) {
        Integer uid = loginService.registerUser(user);
        return Result.ok(MessageEnums.RegisterSuccess, uid);
    }

}
