package cn.ecomb.springcache.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
		System.out.printf("start provider user");
	}

}
