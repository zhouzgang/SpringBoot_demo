package cn.ecomb;

import cn.ecomb.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhouzhigang
 * @date 2018/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class ApplicationTest {

    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception {
//        for (int i = 0; i <100; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
                    sender.send();
//                }
//            });
//        }
    }
}
