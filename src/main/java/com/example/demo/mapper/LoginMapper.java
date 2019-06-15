package com.example.demo.mapper;

import com.example.demo.entity.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//用户信息表
public interface LoginMapper {


    /*
    *  用户登录
    *  @Param("userName") 用户账号信息
        根据userName查找用户信息对比账号是否注册如存此账号证明已注册
        则根据用户前台输入的密码与数据库密码进行对比
     * */
    @Select("SELECT * FROM test_login WHERE username=#{userName}")
    Login getLogin(@Param("userName") String userName);


    /*
     * 注册用户
     *
     * */
    @Insert("INSERT INTO test_login values(#{id},#{name}," +
            "#{userName},#{password},#{phone}," +
            "#{email},#{gender},#{age})")
    Integer addUsers(Login login);


    /*   *//*
     * 修改用户资料
     * *//*
    @Update("UPDATE test_login SET name=#{name},password=#{password}," +
            "phone=#{phone},email=#{email},gender=#{gender},age=#{age}WHERE id=#{id}")
    Integer updateUser(Login login , Integer id);*/


    /**
     * 根据id查找用户是否存在
     */
    @Select("SELECT * FROM test_login WHERE id=#{id}")
    Login addId(@Param("id") Integer id);

    /**
     * 根据用户id修改用户数据
     */
    @Update("UPDATE test_login SET name=#{name},password=#{password},phone=#{phone}," +
            "email=#{email},gender=#{gender},age=#{age} WHERE id=#{id}")
    Integer updateUser(@Param("id") Integer id, Login login);

}
