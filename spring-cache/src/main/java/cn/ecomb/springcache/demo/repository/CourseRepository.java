package cn.ecomb.springcache.demo.repository;

import cn.ecomb.springcache.demo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhouzhigang on 2017/11/7.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
}
