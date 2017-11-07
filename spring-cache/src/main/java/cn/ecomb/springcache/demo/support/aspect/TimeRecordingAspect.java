package cn.ecomb.springcache.demo.support.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhouzhigang on 2017/11/7.
 */
@Aspect
@Component
public class TimeRecordingAspect {

    private final static Logger logger = LoggerFactory.getLogger(TimeRecordingAspect.class);

    @Pointcut("execution(* cn.ecomb.springcache.demo.controller..*(..))")
    private void timePiontCut(){}

    @Around("timePiontCut()")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();
        logger.info("Start time: {}", start);
        Object obj = pjp.proceed();
        long end = System.currentTimeMillis();
        logger.info("End Time: {}, duration: {}", end, end-start);
        return obj;
    }
}
