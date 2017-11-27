package cn.ecomb.springcache.demo.support.listener;

import cn.ecomb.springcache.demo.CacheStartApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author zhouzhigang
 * @date 2017/11/25.
 */
@WebListener
@Component
public class SimpleServletRequestListener implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(CacheStartApplication.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("---> requestDestroyed: {}", sre.getSource());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("---> requestInitialized: {}", sre.getSource());
    }
}
