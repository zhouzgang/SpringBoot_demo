package cn.ecomb.shrio.controller;

import cn.ecomb.shrio.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouzhigang
 * @date 2018/3/8.
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        logger.info("-----> login page");
        return "login 页面";
    }

    @GetMapping("/user")
    public String getUserById() {
        logger.info("-----> user jiekou");
        return "User1";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

    @GetMapping("/index")
    public String index() {
        logger.info("-----> index page");
        return "进入 index 主页";
    }


}
