package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

// @Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，
// 所以统一配置@MapperScan在扫描路径在application类中
public interface StudentMapper {

    //查
    @Select("SELECT * FROM test_user_table WHERE id = #{id}")
    Student getStudentById(Integer id);

    //查全部
    @Select("SELECT * FROM test_user_table")
    public List<Student> getStudentList();

    //增
    @Insert("insert into test_user_table(id,name,age,gender) values(#{id},#{name},#{age},#{gender})")
    public int add(Student student);

    //删
    @Delete("delete from test_user_table where id=#{id}")
    public int delete(Integer id);

    //改
    @Update("update test_user_table set name=#{student.name},age=#{student.age}," +
            "gender=#{student.gender} where" +
            " id=#{id}")
    public int update(@Param("id") Integer id, @Param("student") Student student);


}