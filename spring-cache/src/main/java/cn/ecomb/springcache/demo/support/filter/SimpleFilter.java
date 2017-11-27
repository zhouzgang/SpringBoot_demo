package cn.ecomb.springcache.demo.support.filter;


import cn.ecomb.springcache.demo.CacheStartApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 使用servlet的过滤器注解
 * 同时需要将配置以组件的形式放到IOC容器里
 *
 * @author zhouzhigang
 * @date 2017/11/24.
 */
@WebFilter(filterName = "SimpleFilter", urlPatterns = "/*")
@Component
public class SimpleFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CacheStartApplication.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init SimpleFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("doFilter SimpleFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("destroy SimpleFilter");
    }
}
