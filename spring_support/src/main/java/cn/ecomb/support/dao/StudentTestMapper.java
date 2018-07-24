package cn.ecomb.support.dao;

import cn.ecomb.support.entity.StudentTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/3/6.
 */
@Mapper
public interface StudentTestMapper {

//    @Select("SELECT * FROM students")
//    List<StudentTest> findByName();

    StudentTest getStudentById(String sno);

}
