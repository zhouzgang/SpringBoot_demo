package cn.ecomb.springhttp.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhouzhigang
 * @date 2018/8/2.
 */
@SpringBootApplication
@EnableCaching
public class HttpStartApplication {

    private static final Logger logger = LoggerFactory.getLogger(HttpStartApplication.class);

    @Resource(name = "ecombRestBuilder")
    RestTemplateBuilder ecombRestTemplateBuilder;

    public static void main(String[] args) {
        SpringApplication.run(HttpStartApplication.class, args);
        logger.info("--->Spring http connection demo start success");
    }

    @Bean("ecombRestTemplate")
    RestTemplate restTemplate() {
        return ecombRestTemplateBuilder.build();
    }
}
