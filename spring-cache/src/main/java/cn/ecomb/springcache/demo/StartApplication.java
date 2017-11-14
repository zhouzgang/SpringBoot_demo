package cn.ecomb.springcache.demo;

import cn.ecomb.springcache.demo.service.UserService.impl.UserServiceIml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class StartApplication {

	private static final Logger logger = LoggerFactory.getLogger(StartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
		logger.info("--->Start success");
		logger.debug("--->Start debug success");
		logger.warn("--->Start warn success");
		logger.error("--->Start error success");
		logger.trace("--->Start trace success");
	}

}
