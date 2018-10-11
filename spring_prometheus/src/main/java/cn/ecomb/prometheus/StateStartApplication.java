package cn.ecomb.prometheus;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class StateStartApplication {

	private static final Logger logger = LoggerFactory.getLogger(StateStartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StateStartApplication.class, args);
		logger.info("--->Start success");
	}

}
