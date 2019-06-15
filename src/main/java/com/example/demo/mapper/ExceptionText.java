package com.example.demo.mapper;

import com.example.demo.entity.Login;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 测试自定义异常接口
 * 测试人：xiaolinliu
 */
public interface ExceptionText {

    /**
     * Exception 测试持久层Mapper接口
     * 插入数据
     */
    @Insert("INSERT INTO t_user(id,username,password) values(#{id},#{username},#{password})")
    Integer addnew(User user);


    /**
     * Exception 测试持久层接口
     * 查询数据
     */
    @Select("SELECT * FROM t_user WHERE userName=#{userName}")
    User select(@Param("userName") String userName);

}
