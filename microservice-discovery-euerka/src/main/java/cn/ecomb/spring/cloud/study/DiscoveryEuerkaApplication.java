package cn.ecomb.spring.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryEuerkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryEuerkaApplication.class, args);
		System.out.printf("start provider user");
	}
}
