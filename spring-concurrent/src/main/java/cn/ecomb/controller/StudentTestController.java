package cn.ecomb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouzhigang
 * @date 2018/7/25.
 */
@RestController
public class StudentTestController {


    @GetMapping("/user/test")
    public String getStudentTestBySno() {
        return "fasd";
    }
}
