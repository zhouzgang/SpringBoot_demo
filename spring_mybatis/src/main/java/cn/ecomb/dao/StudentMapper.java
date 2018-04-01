package cn.ecomb.dao;

import cn.ecomb.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/3/6.
 */
@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM students")
    List<Student> findByName();

}
