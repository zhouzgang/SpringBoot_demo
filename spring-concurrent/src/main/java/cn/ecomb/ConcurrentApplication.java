package cn.ecomb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.ecomb"})
public class ConcurrentApplication {

//	@Autowired
//	StudentTestMapper studentTestMapper;

	public static void main(String[] args) {
		SpringApplication.run(ConcurrentApplication.class, args);
	}
}
