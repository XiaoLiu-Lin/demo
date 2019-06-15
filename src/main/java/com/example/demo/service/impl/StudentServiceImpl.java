package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//如果有一个类带了@Service注解，将自动注册到Spring容器，不需要再在applicationContext里面定义bean了
@Service
public class StudentServiceImpl implements StudentService {
    //Autowired:把配置好的Bean拿来用，完成属性、方法的组装
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public int delete(Integer id) {
        return studentMapper.delete(id);
    }

    @Override
    public int update(Integer id, Student student) {
        return studentMapper.update(id, student);
    }
}
