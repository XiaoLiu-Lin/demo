package com.example.demo.controller;

import com.example.demo.entity.util.ResponseResult;
import com.example.demo.service.ex.TestException;
import com.example.demo.service.ex.UserNameException;
import com.example.demo.service.ex2.InsertException;
import com.example.demo.service.ex2.SelectException;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

    public static final Integer SUCCESS = 200;

    @ExceptionHandler({TestException.class,
            FileUploadException.class})
    public ResponseResult<Void>
    handleException(Exception e) {
        // 声明返回对象
        ResponseResult<Void> rr = new ResponseResult<Void>();
        // 在返回对象封装错误提示的文字
        rr.setMessage(e.getMessage());
        // 根据异常的不同，返回的错误代码也不同

        if (e instanceof InsertException) {
            //402-用户插入数据异常
            rr.setState(402);
        } else if (e instanceof SelectException) {
            //402-用户查询数据异常
            rr.setState(403);
        }
        return rr;
    }
}
