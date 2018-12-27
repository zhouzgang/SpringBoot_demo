package cn.ecomb.engine.logic;

import cn.ecomb.engine.Resquest;

import java.util.Objects;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class SignalFilterLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Resquest resquest) {
        System.out.println(Thread.currentThread().getName() + " 执行无效信号过滤");
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(resquest);
        }
    }

}
