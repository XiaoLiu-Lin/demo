package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.service.ex2.InsertException;
import com.example.demo.service.ex2.SelectException;


public interface ExceptionTestSercice {

        /**
         * Exception 测试业务层Service接口
         */
        Integer addNew(User user) throws InsertException;


        /**
         * Exception 测试持久层接口
         * 查询数据
         */
        User selectUser(String userName) throws SelectException;



}
