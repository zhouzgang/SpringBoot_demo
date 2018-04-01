package cn.ecomb.springstatusmachine.demo.controller;

import cn.ecomb.springstatusmachine.demo.demo.Events;
import cn.ecomb.springstatusmachine.demo.demo.States;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouzhigang on 2017/10/27.
 */
@RestController("/state")
//@RequestMapping("/test")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @GetMapping
    public void pay() {
        logger.info("请求  pay 流程");
        stateMachine.sendEvent(Events.PAY);
    }

    @GetMapping("/receive")
    public void receive() {
        logger.info("请求  pay 流程");
        stateMachine.sendEvent(Events.RECEIVE);
    }

}
