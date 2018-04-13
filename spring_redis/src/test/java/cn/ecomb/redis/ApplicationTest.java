package cn.ecomb.redis;

import cn.ecomb.redis.entity.User;
import cn.ecomb.redis.uilts.RedisOperation;
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
    private RedisOperation redisOperation;

    @Test
    public void hello() throws Exception {
        redisOperation.set("hello", "你好");
        System.out.println("---->" + redisOperation.get("hello"));
    }

    @Test
    public void zSet() throws Exception {
        redisOperation.zAdd("myzset", new User("zhou", 24), 5);
        System.out.println("---->" + redisOperation.rangeByScore("myzset", 5, 5));
    }
}
