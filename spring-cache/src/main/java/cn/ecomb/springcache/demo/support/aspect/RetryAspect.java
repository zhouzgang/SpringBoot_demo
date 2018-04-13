package cn.ecomb.springcache.demo.support.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhouzhigang
 * @date 2018/4/6.
 *
 * 接口重试注解处理切面
 *
 */
@Aspect
@Component
public class RetryAspect {

    private final static Logger logger = LoggerFactory.getLogger(RetryAspect.class);

    @Pointcut("@annotation(cn.ecomb.springcache.demo.support.annotation.Retry)")
    public void retryPoint(){}

    @Before("retryPoint()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("doBefore---->" + joinPoint.getArgs().toString());
    }

    /**
     * 方法调用异常，压入到redis队列中，使用定时任务重试调用
     */
    @AfterThrowing("retryPoint()")
    public void doAfterThrowing(JoinPoint joinPoint) {
        logger.info("doAfterThrowing---->" + joinPoint.getArgs().toString());
    }

    /**
     * 方法执行完之后处理逻辑
     */
    @After("retryPoint()")
    public void doAfter(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("doAfter---->, url = {} end of execution", request.getRequestURL());
    }

    /**
     * 方法返回中执行逻辑
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "retryPoint()")
    public void doAfterReturn(Object object){
        logger.info("doAfterReturn---->, response={}",object.toString());
    }


}
