package com.example.demo.controller;

import com.example.demo.entity.Login;
import com.example.demo.entity.util.ResponseResult;
import com.example.demo.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;


    /*
     * 根据userName查找用户信息
     * */
    @GetMapping("/select")
    public ResponseResult<Login> getLogin(
            @Param("userName") String userName,
            @Param("password") String password,
            HttpSession session) {
        Login login = loginService.getLogin(userName, password);
        session.setAttribute("id", login.getId());
        session.setAttribute("userName", login.getUserName());

        return new ResponseResult<Login>(SUCCESS, login);
    }


    /*
     * 注册新用户
     * */
    @GetMapping("/insert")
    public ResponseResult<Integer> addUser(Login login) {
        loginService.addUser2(login);
        return new ResponseResult<Integer>(SUCCESS);
    }


    /**
     * 根据id查找用户是否存在
     */
    @GetMapping("/selects")
    public ResponseResult<Login> addId(Integer id) {
        Login login = loginService.addId(id);

        return new ResponseResult<Login>(SUCCESS, login);
    }

    /**
     * 根据id修改用户数据
     */
    @GetMapping("/update")
    public ResponseResult<Integer> updateUser(Integer id, Login login) {
        Integer rows = loginService.updateUser(id, login);
        return new ResponseResult<>(SUCCESS, rows);
    }
}
