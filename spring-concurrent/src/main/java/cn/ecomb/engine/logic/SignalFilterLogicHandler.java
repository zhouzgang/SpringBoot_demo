package cn.ecomb.engine.logic;

import cn.ecomb.engine.dto.Request;

import java.util.Objects;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class SignalFilterLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Request request) {
        System.out.println(Thread.currentThread().getName() + " 执行无效信号过滤");
        if ("R1".equals(request.getParam())) {
            request.getResponse().setBody("R1->SignalFilterLogicHandler");
            return;
        }
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(request);
        }
    }

}
