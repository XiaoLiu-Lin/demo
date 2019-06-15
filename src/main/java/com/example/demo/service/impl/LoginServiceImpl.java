package com.example.demo.service.impl;

import com.example.demo.entity.Login;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.redis.redisTemplete.JedisUtil;
import com.example.demo.service.LoginService;
import com.example.demo.service.ex.TestException;
import com.example.demo.service.ex.UserNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    Jedis jedis = JedisUtil.getInstance().getPool().getResource();

    //    登录
    @Override
    public Login getLogin(String userName, String password) throws TestException {
        Login list = loginMapper.getLogin(userName);
//        将拿到的userName与数据库的userName进行对比
        if (list == null) {
//         抛出异常，用户不存在；
            throw new TestException("登录失败，用户名不存在！");
        }
        if (list.getPassword().equals(password)) {
//      登录成功返回参数
            list.setPassword(null);
            jedis.set("userName", userName);
            jedis.set("password", password);
            JedisUtil.getInstance().returnJedis(jedis);
            return list;
        } else {
//            登录失败抛出异常
            throw new TestException("登录失败,密码失败!");
        }
    }

    /*
     * 注册用户
     * */
    @Override
    public void addUser2(Login login) throws UserNameException {
        String userName = login.getUserName();
        Login data = loginMapper.getLogin(userName);
        // 为null 用户不存在注册
        if (data == null) {
            //设置不能为空的参数
            if (login.getUserName() == null || login.getGender() == null || login.getAge() == null || login.getPassword() == null || login.getName() == null) {
                throw new UserNameException("注册失败,Gender,Age,Password,Name,userName值不能为空");
            }
            try {
                addUser(login);
            } catch (UserNameException e) {
                e.getMessage();
            }
        } else {
            // 否：非null，用户名被占用，则抛出UserConflictException
            throw new UserNameException(
                    "注册失败！您尝试注册的用户名(" + userName + ")已经被占用！");
        }


    }

    /**
     * 根据id查找修改用户资料
     **/
    @Override
    public Integer updateUser(Integer id, Login login) {
//        Login data = addId(id);
        Integer row = loginMapper.updateUser(id, login);
        if (row != 1) {
            throw new UserNameException("此用户不存在或被删除！");
        }
        return row;
    }


    /**
     * 根据用户id查找用户数据
     */
    @Override
    public Login addId(Integer id) {
        if (id == null) {
            throw new UserNameException("此用户不存在或被删除！");
        }
        Login login = loginMapper.addId(id);

        return login;
    }

    public void addUser(Login login) throws UserNameException {
        Integer rows = loginMapper.addUsers(login);
        if (rows != 1) {
            throw new UserNameException("增加用户数据时出现未知错误！请联系系统管理员！");

        }
    }


}
