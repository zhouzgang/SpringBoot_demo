package cn.ecomb.springcache.demo.support.interceptor;

import cn.ecomb.springcache.demo.CacheStartApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhouzhigang
 * @date 2017/11/25.
 */
public class Simple1Interceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CacheStartApplication.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("-----> Simple1, preHandle: ");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.info("-----> Simple1, postHandle: ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        logger.info("-----> Simple1, afterHandle: ");
    }
}
