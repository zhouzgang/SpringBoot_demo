package cn.ecomb.redis;

import cn.ecomb.redis.service.RedisService;
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
@SpringBootTest(classes = RedisApplication.class)
public class ApplicationTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void hello() throws Exception {
        redisService.set("hello", "你好");
        System.out.println("---->" + redisService.get("hello"));
    }
}
