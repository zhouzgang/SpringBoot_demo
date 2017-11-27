package cn.ecomb.springcache.demo.repository;

import cn.ecomb.springcache.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouzhigang on 2017/6/18.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
