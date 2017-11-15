package cn.ecomb.springcache.demo.controller;

import cn.ecomb.springcache.demo.support.exception.custom.ServiceException;
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
    public void getCourse() throws Exception {
        throw new ServiceException(50001, "service报错");
    }
}
