package cn.ecomb.redis.mq;

import cn.ecomb.redis.uilts.RedisOperation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhouzhigang
 * @date 2018/4/11.
 */
public class SimpleTaskMQ implements TaskMQ<AbstractTask>{

    @Autowired
    private RedisOperation redisOperation;

    @Override
    public void sendTask(AbstractTask task) {
        redisOperation.rPush(task.getQueueKey(), task.Object2Json());
    }

    @Override
    public void processTask(AbstractTask task) {
        while (true) {
            try {
                // 有问题，获取不到有优先级的 key
                task.Json2Object(redisOperation.lPop(task.getQueueKey(), 30));
                if (task.getObject() == null) {
                    // todo 获取两条纪录，判断下一次执行时间
                    Thread.sleep(1000);
                    continue;
                }
                // todo 执行队列  先阻塞执行，之后改为使用任务执行器
                task.task();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
