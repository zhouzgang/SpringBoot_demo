package cn.ecomb.springcache.demo.support.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhouzhigang
 * @date 2017/11/25.
 */
@Configuration
public class WebAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Simple1Interceptor()).addPathPatterns("/*");
        registry.addInterceptor(new Simple2Interceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }
}
