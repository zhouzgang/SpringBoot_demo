package cn.ecomb.engine.logic;

import cn.ecomb.engine.dto.Request;

import java.util.Objects;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class AppConfigLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Request request) {
        System.out.println(Thread.currentThread().getName() + " 根据不同的手机厂商配置场景");
        if ("R3".equals(request.getParam())) {
            request.getResponse().setBody("R3->AppConfigLogicHandler");
            return;
        }
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(request);
        }

    }

}
