package cn.ecomb.redis.mq;

/**
 * @author zhouzhigang
 * @date 2018/4/11.
 *
 * 任务抽象类
 */
public abstract class AbstractTask {

    /**
     * 需要提交到 redis 的任务信息
     * 使用 json 格式序列化 taskInfo 对象
     */
    private Object param;

    /**
     * 不同优先级队列的 key
     * 没有则使用默认队列
     * todo redis 的 key 定义规范
     */
    private Priority priority;

    public AbstractTask(Object param) {
        this.param = param;
        this.priority = Priority.DEFAULT;
    }


    public AbstractTask(Object param, Priority priority) {
        this.param = param;
        this.priority = priority;
    }

    /**
     * todo 任务执行完后需要返回值吗？
      */
    public abstract void task();

    public String getQueueKey() {
        return priority.getQueueKey(this.getClass().getName());
    }

    /**
     * 将 taskInfo 解析成 JSON 字符串
     */
    public String Object2Json() {
        return "JSON";
    }

    /**
     * 将 JSON 字符串 解析成 taskInfo
     */
    public Object Json2Object(Object json){
        this.param = json;
        return param;
    }

    public Object getObject() {
        return param;
    }

    public AbstractTask setObject(Object t) {
        this.param = param;
        return this;
    }

    public Priority getPriority() {
        return priority;
    }

    public AbstractTask setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }



    /**
     * 不同优先级队列
     */
    enum Priority {

        HIGH_DELAYED {
            @Override
            public String getQueueKey(String taskName)   { return "high:dqueue:" + taskName; }
        },

        HIGH {
            @Override
            public String getQueueKey(String taskName)   { return "high:queue:" + taskName; }
        },

        MIDDLE_DELAYED {
            @Override
            public String getQueueKey(String taskName)   { return "middle:dqueue:" + taskName; }
        },

        MIDDLE {
            @Override
            public String getQueueKey(String taskName)   { return "middle:queue:" + taskName; }
        },

        LOW_DELAYED {
            @Override
            public String getQueueKey(String taskName)   { return "low:dqueue:" + taskName; }
        },

        LOW {
            @Override
            public String getQueueKey(String taskName)   { return "low:queue:" + taskName; }
        },

        DEFAULT {
            @Override
            public String getQueueKey(String taskName)   { return "queue:" + taskName; }
        };

        Priority() {}

        public String getQueueKey(String taskName)   { throw new AbstractMethodError(); }

    }

}
