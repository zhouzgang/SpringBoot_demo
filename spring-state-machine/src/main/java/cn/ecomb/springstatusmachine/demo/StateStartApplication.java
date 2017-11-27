package cn.ecomb.springstatusmachine.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StateStartApplication {

	private static final Logger logger = LoggerFactory.getLogger(StateStartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StateStartApplication.class, args);
		logger.info("--->Start success");
	}

}
