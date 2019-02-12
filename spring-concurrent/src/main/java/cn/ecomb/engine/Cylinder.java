package cn.ecomb.engine;

import cn.ecomb.engine.dto.Request;
import cn.ecomb.engine.logic.LogicHandler;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class Cylinder implements Runnable{

    private CountDownLatch latch;

    private Request request;

    private LogicHandler head;

    public Cylinder() {
    }

    public Cylinder(CountDownLatch latch, Request request, LogicHandler head) {
        this.latch = latch;
        this.request = request;
        this.head = head;
    }

    @Override
    public void run() {
        try {
            head.handleRequest(request);
            System.out.println("气缸输出一点动能！！！");
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.latch.countDown();
        }
    }
}
