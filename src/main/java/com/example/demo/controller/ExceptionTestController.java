package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.util.ResponseResult;
import com.example.demo.service.ExceptionTestSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exception 测试
 */
@RestController
@RequestMapping("/Exception")
public class ExceptionTestController extends BaseController {

    @Autowired
    private ExceptionTestSercice exceptionTestSercice;

    /**
     * Exception 测试业务层Service接口
     * 查询数据
     */
    @GetMapping("/select")
    public ResponseResult<User> selectUser(String userName) {

        User user = exceptionTestSercice.selectUser(userName);
        return new ResponseResult<User>(SUCCESS, user);
    }

    /**
     * Exception 测试业务层Service接口
     * 插入数据
     */
    @GetMapping("/insert")
    public ResponseResult<Integer> addNew(User user) {
        User data = exceptionTestSercice.selectUser(user.getUserName());
        exceptionTestSercice.addNew(data);
        return new ResponseResult<Integer>(SUCCESS);
    }
}
