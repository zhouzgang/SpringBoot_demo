package cn.ecomb.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhouzg
 * @date 2018/9/25
 */
public class Receiver {

    Logger logger = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.helloworld}")
    public void receive(String payload) {
        logger.info("received payload='{}'",payload);
        latch.countDown();
    }
}

