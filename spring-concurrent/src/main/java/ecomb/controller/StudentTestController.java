package cn.ecomb.controller;

import cn.ecomb.entity.Student;
import cn.ecomb.service.StudentService;
import cn.ecomb.support.entity.StudentTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/7/25.
 */
@RestController
//@RequestMapping("/user")
public class StudentTestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/user")
    public Student getStudentTest() {
        return studentService.findByName("108");
    }

    @GetMapping("/user/test")
    public StudentTest getStudentTestBySno() {
        return studentService.findByStudentById("108");
    }
}
