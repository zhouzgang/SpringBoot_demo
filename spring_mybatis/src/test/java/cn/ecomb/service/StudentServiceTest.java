package cn.ecomb.service;

import cn.ecomb.MybatisDemoApplication;
import cn.ecomb.entity.Student;
import cn.ecomb.support.entity.StudentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhouzhigang
 * @date 2018/7/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MybatisDemoApplication.class)
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    public void findByName() throws Exception {
        Student student =studentService.findByName("108");
        System.out.println("--->"+ student.toString());
    }

}