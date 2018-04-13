package cn.ecomb.redis.mq;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author zhouzhigang
 * @date 2018/4/11.
 *
 * 基于 redis 实现简单消息队列接口定义
 * 1. 使用 rpush 命令推送任务至队列右边
 * 2. 使用阻塞命令 BLPOP 弹出左边的待处理任务
 *
 * todo 区分不同功能的队列
 */
public interface TaskMQ<T> {

    /**
     * 使用 rpush 命令推送任务至队列右边
     * @param t
     * @return
     */
    void sendTask(T t);

    /**
     * 使用阻塞命令 BLPOP 弹出左边的待处理任务
     * todo 怎么处理 worker process
     * @param t
     * @return
     */
    void processTask(T t);

}
