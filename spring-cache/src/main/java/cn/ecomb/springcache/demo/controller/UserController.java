package cn.ecomb.springcache.demo.controller;

import cn.ecomb.springcache.demo.entity.User;
import cn.ecomb.springcache.demo.controller.vo.req.UserParamVO;
import cn.ecomb.springcache.demo.service.UserService.UserService;
import cn.ecomb.springcache.demo.service.UserService.impl.UserServiceIml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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
    public User findOne(@NotNull(message = "用户Id不能空")
                            @PathVariable Long id) {
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

    @GetMapping
    public User queryUser(@Validated UserParamVO userParamVO) {
        return userService.findOne(1L);
    }
}
