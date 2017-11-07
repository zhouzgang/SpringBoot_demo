package cn.ecomb.springcache.demo.support.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhouzhigang on 2017/11/7.
 */
@Aspect
@Component
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * execution（public * *（..））任意公共方法的执行.
     *           访问权限，返回值，方法绝对路径，方法参数
     *           *(任意)，*(任意返回类型)，set*(以set开头的方法)，(..)(任意多参数)||(*)(一个任意参数)||(*，String)(第一个任意参数，第二个为String类型)
     */
    @Pointcut("execution(public * cn.ecomb.springcache.demo.controller..*(..))")
    private void logPointCut(){}

    @Before(value = "logPointCut()")
    public void LogTreadId(){
        logger.info(Thread.currentThread().getName());
    }

}
