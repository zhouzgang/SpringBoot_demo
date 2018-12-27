package cn.ecomb.springhttp.demo.support.resource;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhouzhigang
 * @date 2018/8/2.
 */
@Component
public class EcombRestTemplateBuilder {

    private static final String HTTP_HOST = "http://localhost:8080";

    @Bean(name = "ecombRestBuilder")
    RestTemplateBuilder restTemplateBuilder() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.rootUri(HTTP_HOST);
        restTemplateBuilder.requestFactory(httpRequestFactory());
        restTemplateBuilder.additionalInterceptors(new UserAgentInterceptor());
        restTemplateBuilder.errorHandler(new CustomErrorHandler());

        return restTemplateBuilder;
    }


    @Bean
    public CloseableHttpClient httpClient() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(5);
        connectionManager.setDefaultMaxPerRoute(5);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(8000)
                .setConnectTimeout(8000)
                .setConnectionRequestTimeout(8000)
                .build();

        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }

    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }
}
