package cn.ecomb.engine.logic;

import cn.ecomb.engine.dto.Request;

import java.util.Objects;

/**
 * 推荐服务逻辑
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class RecommendationLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Request request) {
        System.out.println(Thread.currentThread().getName() + " 根据不同的场景推荐服务");
        if ("R4".equals(request.getParam())) {
            request.getResponse().setBody("R4->RecommendationLogicHandler");
            return;
        }
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(request);
        }

    }

}
