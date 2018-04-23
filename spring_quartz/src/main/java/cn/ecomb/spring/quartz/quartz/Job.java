package cn.ecomb.spring.quartz.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author zhouzhigang
 * @date 2018/3/8.
 */
public interface Job extends org.quartz.Job{
    void execute(JobExecutionContext paramJobExecutionContext) throws JobExecutionException;
}
