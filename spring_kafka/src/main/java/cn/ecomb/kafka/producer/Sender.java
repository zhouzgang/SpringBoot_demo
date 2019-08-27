package cn.ecomb.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author zhouzg
 * @date 2018/9/25
 */
public class Sender {

    Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String topic,String payload) {
        logger.info("sending payload='{}' to topic='{}'",payload,topic);
        this.kafkaTemplate.send(topic,payload);
    }
}
