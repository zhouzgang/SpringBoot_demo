package cn.ecomb.engine.logic;

import cn.ecomb.engine.dto.Request;

import java.util.Objects;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class HeadLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Request request) {
        System.out.println(Thread.currentThread().getName() + " 逻辑链头部开启");
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(request);
        }
    }

}
