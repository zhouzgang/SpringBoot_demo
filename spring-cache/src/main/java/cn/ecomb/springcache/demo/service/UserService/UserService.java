package cn.ecomb.springcache.demo.service.UserService;

import cn.ecomb.springcache.demo.Entity.User;

/**
 * Created by zhouzhigang on 2017/10/27.
 */
public interface UserService {

    User getUserById(Long userId);

    User findOne(Long userId);

    void remove(Long userId);

    void save(User user);

    User update(User user);
}
