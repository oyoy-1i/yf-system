package com.yfsystem.service;

import com.yfsystem.pojo.User;

public interface LoginService {

    public String login(String username, String password);


    User getUserInfo(String token);

    Integer registerUser(User user);
}
