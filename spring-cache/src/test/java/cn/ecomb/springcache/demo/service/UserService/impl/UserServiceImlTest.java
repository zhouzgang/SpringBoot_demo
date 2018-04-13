package cn.ecomb.springcache.demo.service.UserService.impl;

import cn.ecomb.springcache.demo.entity.User;
import cn.ecomb.springcache.demo.service.UserService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhouzhigang on 2017/10/27.
 */
//@RunWith(Arquillian.class)
public class UserServiceImlTest {
    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImlTest.class);

    @org.junit.Test
    public void findOne() throws Exception {
        User user = userService.findOne("1");
        logger.info(String.valueOf(user));
    }

    @org.junit.Test
    public void remove() throws Exception {
    }

    @org.junit.Test
    public void save() throws Exception {
    }

}
