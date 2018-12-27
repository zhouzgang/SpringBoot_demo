package cn.ecomb.kafka;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


/**
 * @author zhouzg
 * @date 2018/9/25
 */
@Component
public class KafkaAppender extends AppenderBase<ILoggingEvent> {
    private Logger logger = LoggerFactory.getLogger(KafkaAppender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();
    private String topic;
    private String zookeeperHost;
    private String brokerList;
    private Formatter formatter;

    @Override
    public void start() {
        append(null);
    }

    @Override
    public void stop() {

    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        //讲日志转换成json
        String payload = this.formatter.format(iLoggingEvent);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("test", "test1");
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("kafka sendMessage error, ex = {}, topic = {}, data = {}", ex, "test", "test1");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("kafka sendMessage success topic = {}, data = {}","test", "test1");
            }
        });
    }
}
