package cn.ecomb.spring_quartz;

import cn.ecomb.spring_quartz.quartz.JobOne;
import cn.ecomb.spring_quartz.quartz.QuartzUtil;
import org.quartz.SchedulerException;

/**
 * @author zhouzhigang
 * @date 2018/3/8.
 */
public class QuartzApplication {
    public static void main(String[] args) {
        try {
            QuartzUtil.addJob("JobOne","triggerName",  JobOne.class, 3);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
