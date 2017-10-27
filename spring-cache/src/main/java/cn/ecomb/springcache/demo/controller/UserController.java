package cn.ecomb.springcache.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouzhigang on 2017/10/27.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUser() {
        return "user";
    }
}
