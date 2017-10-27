package cn.ecomb.springcache.demo.service.UserService.impl;

import cn.ecomb.springcache.demo.Entity.User;
import cn.ecomb.springcache.demo.repository.UserReository;
import cn.ecomb.springcache.demo.service.UserService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * Created by zhouzhigang on 2017/10/27.
 */
@Service
public class UserServiceIml implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceIml.class);

    @Autowired
    private UserReository userReository;

    @Override
    @Cacheable(value="user", key = "#user.id")
    @Caching
    public User findOne(long userId) {
        logger.info("");
        return userReository.findOne(userId);
    }

    @Override
    @CacheEvict(value = "user")
    public void remove(long userId) {

    }

    @Override
    @CachePut(value = "user", key = "#user.id")
    public void save(User user) {
        userReository.save(user);
    }


}
