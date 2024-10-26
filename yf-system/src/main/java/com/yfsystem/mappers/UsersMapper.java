package com.yfsystem.mappers;

import com.yfsystem.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * ClassName UsersMapper
 * Author OuYangYiFan
 * Description TODO
 * DATA 2024/10/23 下午11:49
 * Version 1.0
 */

@Mapper
public interface UsersMapper {
    @Select("select * from tb_users where uname=#{uname} and upwd=#{pwd}")
    public User queryUserByUsernameAndPwd(@Param("uname") String uname, @Param("pwd") String pwd);

    @Select("select * from tb_users where uname=#{uname}")
    public User queryUserByUsername(@Param("uname") String uname);
    @Insert("insert into tb_users(uname,upwd) values(#{uname},#{upwd})")
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    public Integer addUser(User user);
}
