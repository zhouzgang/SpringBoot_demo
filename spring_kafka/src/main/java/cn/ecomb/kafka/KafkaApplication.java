package cn.ecomb.kafka;

import cn.ecomb.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhouzg
 * @date 2018/9/25
 */
@SpringBootApplication
public class KafkaApplication {


    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class,args);
    }
}
