package cn.ecomb.springcache.demo.service.UserService;

import cn.ecomb.springcache.demo.Entity.User;

/**
 * Created by zhouzhigang on 2017/10/27.
 */
public interface UserService {

    User findOne(long userId);

    void remove(long userId);

    void save(User user);
}
