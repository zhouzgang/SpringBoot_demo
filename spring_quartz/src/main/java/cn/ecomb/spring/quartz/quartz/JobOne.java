package cn.ecomb.spring.quartz.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author zhouzhigang
 * @date 2018/3/8.
 */
public class JobOne implements Job{
    @Override
    public void execute(JobExecutionContext paramJobExecutionContext) throws JobExecutionException {
        System.out.println("----->execute JobOne");
    }
}
