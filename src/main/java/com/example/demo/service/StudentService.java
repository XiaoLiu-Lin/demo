package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    //通过id查询
    Student getStudentById(Integer id);

    //获取用户列表
    public List<Student> getStudentList();

    //增
    public int add(Student student);

    //删
    public int delete(Integer id);

    //改
    public int update(Integer id, Student student);
}