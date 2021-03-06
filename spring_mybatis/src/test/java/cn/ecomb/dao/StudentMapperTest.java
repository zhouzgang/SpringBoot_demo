package cn.ecomb.dao;

import cn.ecomb.MybatisDemoApplication;
import cn.ecomb.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhouzhigang
 * @date 2018/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MybatisDemoApplication.class)
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void findByName() throws Exception {
        List<Student> student = studentMapper.findByName();
        System.out.println("--->"+ student.get(1).toString());
    }

}