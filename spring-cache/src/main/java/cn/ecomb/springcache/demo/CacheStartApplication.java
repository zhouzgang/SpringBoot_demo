package cn.ecomb.springcache.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheStartApplication {

	private static final Logger logger = LoggerFactory.getLogger(CacheStartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CacheStartApplication.class, args);
		logger.info("--->Start success");
		logger.debug("--->Start debug success");
		logger.warn("--->Start warn success");
		logger.error("--->Start error success");
		logger.trace("--->Start trace success");
	}

//	@Bean
//	public MethodValidationPostProcessor methodValidationPostProcessor(){
//		return new MethodValidationPostProcessor();
//	}

}
