package com.yfsystem.service.impl;

import com.yfsystem.enums.MessageEnums;
import com.yfsystem.exceptions.YfSystemException;
import com.yfsystem.mappers.UsersMapper;
import com.yfsystem.pojo.User;
import com.yfsystem.service.LoginService;
import com.yfsystem.utils.JWTUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * ClassName LoginServerImpl
 * Author OuYangYiFan
 * Description TODO
 * DATA 2024/10/22 下午9:27
 * Version 1.0
 */
@Service
public class LoginServerImpl implements LoginService {

    private static final Log log = LogFactory.getLog(LoginServerImpl.class);
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public String login(String username, String password) {
        User user = usersMapper.queryUserByUsernameAndPwd(username, password);
        return JWTUtil.createToken(user);
    }

    @Override
    public User getUserInfo(String token) {
        if (Objects.isNull(token)) {
            throw new YfSystemException(MessageEnums.LoginAgain);
        }
        return JWTUtil.parseToken(token);
    }

    @Override
    public Integer registerUser(User user) {
        if (user == null) {
            throw new YfSystemException(MessageEnums.RegisterError);
        }else {
            User user1 = usersMapper.queryUserByUsername(user.uname);
            System.out.println(user1);
            System.out.println(user1 != null);
            if (user1 != null) {
                throw new YfSystemException(MessageEnums.RegisterError);
            }else {
                System.out.println("注册成功");
                usersMapper.addUser(user);
            }
        }

        return user.getUid();
    }

}
