package cn.ecomb.springhttp.demo.support.resource;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate 全局配置
 * @author zhouzhigang
 * @date 2018/8/2.
 */
@Component
public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        new RestTemplateBuilder()
                .detectRequestFactory(false)
                .basicAuthorization("username", "password")
//                在具体实例中区分不同 httpclient
//                .uriTemplateHandler(new OkHttp3ClientHttpRequestFactory())
//                .errorHandler(new CustomErrorHandler())
                .configure(restTemplate);
    }
}
