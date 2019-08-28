package cn.ecomb.engine;


import cn.ecomb.engine.dto.PoiList;
import cn.ecomb.engine.dto.Response;
import cn.ecomb.engine.dto.Request;
import cn.ecomb.engine.logic.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author zhouzhigang
 * @date 2018/4/24.
 */
@Component
public class EcombEngineV {

    private static int maxPoolSize = 200;
    static final ExecutorService executors = new ThreadPoolExecutor(5,
            maxPoolSize,
            60L,
            TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

//    private static int threadNum = 4;
//    private static CountDownLatch latch = new CountDownLatch(threadNum);

    HeadLogicHandler head = new HeadLogicHandler();


    public LogicHandler init() {
        System.out.println("引擎初始化逻辑链路");
        LogicHandler signal = new SignalFilterLogicHandler();
        LogicHandler recognize = new RecognizeLogicHandler();
        LogicHandler appConfig = new AppConfigLogicHandler();
        LogicHandler recommendation = new RecommendationLogicHandler();
        head.setNextHandler(signal);
        signal.setNextHandler(recognize);
        recognize.setNextHandler(appConfig);
        appConfig.setNextHandler(recommendation);
        return head;
    }

    public List<Response> start(Request request) {
        System.out.println("----Lamborghini Centenario 启动----");
        int threadNum = request.getResponse().getPoiList().size();
        CountDownLatch latch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            PoiList poiList = request.getResponse().getPoiList().get(i);
            request.setResponse(new Response("Cylinder-" + i, request));
            executors.execute(new Cylinder(latch, request, head));
        }

        try {
            //阻塞当前线程，直到所有员工到达公司大门口之后才执行
//            latch.await();
            // 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断或超出了指定的等待时间。
            // 当处理时间真的超过 3s 时，有些结果就会被丢弃掉。
            latch.await(300, TimeUnit.MILLISECONDS);
            System.out.println("所有定位结果都已经执行完逻辑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //最后关闭线程池，但执行以前提交的任务，不接受新任务
//            executors.shutdown();
            //关闭线程池，停止所有正在执行的活动任务，暂停处理正在等待的任务，并返回等待执行的任务列表。
            //threadPool.shutdownNow();
        }

//        for (int i = 0; i < threadNum; i++) {
//            System.out.println(requests.get(i).getResponse().getUid() + ": " + requests.get(i).getResponse().getBody());
//        }
//
//        System.out.println("逻辑引擎处理完毕～～～");
//        return requests.stream()
//                .map(request -> request.getResponse())
//                .collect(Collectors.toList());
        return null;
    }

    public void run() {

    }

    public void finish() {

    }


}
