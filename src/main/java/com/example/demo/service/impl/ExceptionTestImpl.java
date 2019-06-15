package com.example.demo.service.impl;

import com.example.demo.entity.Login;
import com.example.demo.entity.User;
import com.example.demo.mapper.ExceptionText;
import com.example.demo.service.ExceptionTestSercice;
import com.example.demo.service.ex2.InsertException;
import com.example.demo.service.ex2.SelectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 处理用户业务层实现类
 */

@Service
public class ExceptionTestImpl implements ExceptionTestSercice {

    @Autowired
    private ExceptionText exceptionText;

    /**
     * Exception 测试持久层接口
     * 插入数据
     */
    @Override
    public Integer addNew(User user) throws InsertException {
        User data = exceptionText.select(user.getUserName());
        if (data != null) {
            throw new InsertException("插入数据失败，该用户已存在！");
        }
        user.setId(data.getId());
        user.setPassword(data.getPassword());
        user.setUserName(data.getUserName());
        return exceptionText.addnew(user);
    }


    /**
     * Exception 测试持久层接口
     * 查询数据
     */
    @Override

    public User selectUser(String userName) throws SelectException {
        User user = exceptionText.select(userName);
//        if (user == null) {
//            throw new SelectException("查询数据失败，该用户不存在或已被删除！");
//        }
        return user;
    }
}
