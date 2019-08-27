package cn.ecomb.engine.logic;

import cn.ecomb.engine.dto.Request;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public abstract class LogicHandler {

    protected LogicHandler nextHandler;

    public abstract void handleRequest(Request request);

    public LogicHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(LogicHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
