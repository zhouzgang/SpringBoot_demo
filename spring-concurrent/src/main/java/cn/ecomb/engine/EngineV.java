package cn.ecomb.engine;

import cn.ecomb.engine.logic.LogicHandler;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public interface EngineV {

    LogicHandler init();

    void start();

    void run();

    void finish();

}
