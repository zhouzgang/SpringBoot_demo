package cn.ecomb.spring.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author zhouzhigang
 * @date 2018/4/20.
 */
public class MyJobListener implements JobExecutionListener{

    Logger logger = LoggerFactory.getLogger(MyJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("---->beforeJob");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("---->afterJob");
    }
}
