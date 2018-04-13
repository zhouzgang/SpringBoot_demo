package cn.ecomb.springcache.demo.service.UserService.impl;

import cn.ecomb.springcache.demo.entity.User;
import cn.ecomb.springcache.demo.repository.UserRepository;
import cn.ecomb.springcache.demo.service.UserService.UserService;
import cn.ecomb.springcache.demo.support.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by zhouzhigang on 2017/10/27.
 */
@Service
public class UserServiceIml implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceIml.class);

    @Autowired
    private UserRepository userReository;

    @Override
    @Cacheable(value="user", key = "#userId")
    @Retry(time = "5")
    public User getUserById(String userId) {
        logger.warn("第一次，线程编号：" + Thread.currentThread().getName());
        return findOne(userId);
    }

    @Override
    @Cacheable(value="user", key = "#userId")
    public User findOne(String userId) {

        logger.info("去数据库中获取...{}", userId);
        logger.warn("第二次，线程编号：" + Thread.currentThread().getName());
        return userReository.findOne(Long.parseLong(userId));
    }

    @Override
    @CacheEvict(value = "user")
    public void remove(Long userId) {
        logger.info("去数据库中移除...{}", userId);
        userReository.delete(userId);
    }

    @Override
    @CachePut(value = "user", key = "#user.id")
    public void save(User user) {
        logger.info("去数据库中获取,并向缓存中添加缓存...{}", user.getId());
        userReository.save(user);
    }

    @Override
    @CachePut(value = "user", key = "#user.id")
    public User update(User user) {
        logger.warn(Thread.currentThread().getName());
        return userReository.save(user);
    }


}
