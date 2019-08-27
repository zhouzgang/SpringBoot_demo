package cn.ecomb.engine.logic;

import cn.ecomb.engine.dto.Request;

import java.util.Objects;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class RecognizeLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Request request) {
        System.out.println(Thread.currentThread().getName() + " 识别出场景类型");
        if ("R2".equals(request.getParam())) {
            request.getResponse().setBody("R2->RecognizeLogicHandler");
            return;
        }
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(request);
        }
    }

}
