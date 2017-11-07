package cn.ecomb.springcache.demo.controller;

import cn.ecomb.springcache.demo.Entity.User;
import cn.ecomb.springcache.demo.service.UserService.UserService;
import cn.ecomb.springcache.demo.service.UserService.impl.UserServiceIml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhouzhigang on 2017/10/27.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserServiceIml.class);

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        logger.warn(Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        User user = userService.getUserById(id);
        long end = System.currentTimeMillis();
        long duration = end - start;
        logger.info("使用时间：{}", duration);
        return user;
    }

    @PutMapping("/{id}")
    public void updateOne(User user) {
        userService.update(user);
    }
}
