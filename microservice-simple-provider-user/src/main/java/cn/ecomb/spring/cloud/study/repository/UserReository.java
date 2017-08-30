package cn.ecomb.spring.cloud.study.repository;

import cn.ecomb.spring.cloud.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouzhigang on 2017/6/18.
 */
@Repository
public interface UserReository extends JpaRepository<User, Long>{

}
