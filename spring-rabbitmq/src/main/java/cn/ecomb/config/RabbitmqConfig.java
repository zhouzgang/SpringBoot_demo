package cn.ecomb.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * @author zhouzhigang
 * @date 2018/3/16.
 */
@Component
public class RabbitmqConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
