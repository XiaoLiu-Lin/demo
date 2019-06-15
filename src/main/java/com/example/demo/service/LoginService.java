package com.example.demo.service;

import com.example.demo.entity.Login;
import com.example.demo.service.ex.TestException;
import com.example.demo.service.ex.UserNameException;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LoginService {

    /*
     * 根据userName查找用户信息
     * */
    Login getLogin(String userName, String password) throws TestException;


    /*
     * 用户注册
     * */
    void addUser2(Login login) throws UserNameException;


    /**
     * 根据用户id修改用户数据
     */
    Integer updateUser(Integer id, Login login);


    /**
     * 根据id查找用户是否存在
     */
    Login addId(Integer id);
}
