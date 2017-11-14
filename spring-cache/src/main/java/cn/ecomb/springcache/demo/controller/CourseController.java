package cn.ecomb.springcache.demo.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouzhigang on 2017/11/7.
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @GetMapping
    public void getCourse(@Param("id") long id) throws Exception {
        throw new Exception("getCourse()");
    }
}
