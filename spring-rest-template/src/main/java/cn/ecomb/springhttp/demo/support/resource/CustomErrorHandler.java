package cn.ecomb.springhttp.demo.support.resource;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

/**
 * @author zhouzhigang
 * @date 2018/8/2.
 */
public class CustomErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

    }

}
