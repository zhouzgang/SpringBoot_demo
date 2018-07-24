package cn.ecomb;

import cn.ecomb.support.dao.StudentTestMapper;
import cn.ecomb.support.entity.StudentTest;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.ecomb"})
@MapperScan(basePackages = {"cn.ecomb.dao", "cn.ecomb.**.dao"})
public class MybatisDemoApplication {

//	@Autowired
//	StudentTestMapper studentTestMapper;

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}
}
