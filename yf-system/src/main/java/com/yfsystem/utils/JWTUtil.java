package com.yfsystem.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.yfsystem.enums.MessageEnums;
import com.yfsystem.exceptions.YfSystemException;
import com.yfsystem.pojo.User;


/**
 * ClassName JWTUtil
 * Author OuYangYiFan
 * Description TODO
 * DATA 2024/10/22 下午10:48
 * Version 1.0
 */
public class JWTUtil {
    private static final String SECRET = "v22Z7Y-DOGkE94PvkmzqjPyFjg1orMcPQmicD_Y7hnA";

    public static String createToken(User user) {
        if (user == null) {
            throw new YfSystemException(MessageEnums.LoginErrorByUserNameOrPassword);
        }
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.create().withIssuer("欧阳一凡")
                .withClaim("user", new Gson().toJson(user))
                .sign(algorithm);
    }

    public static User parseToken(String token) {
        DecodedJWT verify = null;
           try {
               verify = JWT.require(Algorithm.HMAC256(SECRET))
                       .withIssuer("欧阳一凡")
                       .build()
                       .verify(token);
           }catch (Exception ex){
               throw new YfSystemException(MessageEnums.ParseTokenError);
           }
        return new Gson().fromJson(verify.getClaim("user").asString(), User.class);
    }

}
