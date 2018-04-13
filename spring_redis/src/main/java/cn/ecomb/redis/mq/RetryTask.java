package cn.ecomb.redis.mq;

import cn.ecomb.redis.entity.User;

/**
 * @author zhouzhigang
 * @date 2018/4/11.
 */
public class RetryTask extends AbstractTask{

    public RetryTask(User user) {
        super(user);
    }

    public RetryTask(User user, Priority priority) {
        super(user, priority);
    }

    @Override
    public void task() {
        System.out.println("to do task: " + this.getClass().getName() +
                "priority is: " + this.getPriority().toString() +
                "param is:" + this.getObject());
    }
}
