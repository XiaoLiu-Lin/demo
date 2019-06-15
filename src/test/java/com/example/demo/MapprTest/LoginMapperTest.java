package com.example.demo.MapprTest;

import com.example.demo.entity.Login;
import com.example.demo.mapper.LoginMapper;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginMapperTest {

    @Autowired
    private LoginMapper loginMapper;

    @Test
    public void updateUser() {
        Integer id = 1;
        Login login = new Login();
        login.setName("123");
        login.setAge(25);
        Integer rows = loginMapper.updateUser(id, login);
        System.err.println("发生变化数为" + rows);
    }

}
