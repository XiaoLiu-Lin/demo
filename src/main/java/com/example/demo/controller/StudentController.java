package com.example.demo.controller;

import com.example.demo.entity.JsonResult;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 根据ID查询学生
     *
     * @param id
     * @return
     */
    //@PathVariable:用于获取url中的数据
    @GetMapping(value = "student/query/{id}")
    public Student getStudentById(@PathVariable(value = "id") Integer id) {
        try {
            Student student = studentService.getStudentById(id);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    /**
     * 查询学生成绩列表
     *
     * @return
     */
    @RequestMapping(value = "students/query", method = RequestMethod.GET)
    public List<Student> getStudentList() {

        try {
            List<Student> students = studentService.getStudentList();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "student/add", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> add(Student student) {
        JsonResult r = new JsonResult();

        try {
            int orderId = studentService.add(student);
            if (orderId < 0) {
                r.setResult(orderId);
                r.setStatus("failed");
            } else {
                r.setResult(orderId);
                r.setStatus("ok");
            }

        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }

        return ResponseEntity.ok(r);

    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/student/delete", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> delete(@RequestParam(value = "id") Integer id) {
        JsonResult r = new JsonResult();

        try {
            int delId = studentService.delete(id);
            if (delId < 0) {
                r.setResult(delId);
                r.setStatus("failed");
            } else {
                r.setResult(delId);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }

        return ResponseEntity.ok(r);

    }

    /**
     * 根据id修改用户信息
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/student/update", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> update(Student student) {
        JsonResult r = new JsonResult();

        try {
            int ret = studentService.update(student.getId(), student);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }

        return ResponseEntity.ok(r);
    }


}
