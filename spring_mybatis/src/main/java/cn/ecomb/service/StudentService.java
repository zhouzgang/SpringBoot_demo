package cn.ecomb.service;

import cn.ecomb.dao.StudentMapper;
import cn.ecomb.entity.Student;
import cn.ecomb.support.dao.StudentTestMapper;
import cn.ecomb.support.entity.StudentTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouzhigang
 * @date 2018/7/25.
 */
@Service
public class StudentService {

    @Autowired
    StudentTestMapper studentTestMapper;

    @Autowired
    StudentMapper studentMapper;

    public Student findByName(String sno) {
        return studentMapper.getStudentById();
    }

    public StudentTest findByStudentById(String sno) {
        return studentTestMapper.getStudentById(sno);
    }
}
