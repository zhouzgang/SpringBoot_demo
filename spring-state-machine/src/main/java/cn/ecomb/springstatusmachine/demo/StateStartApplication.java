package cn.ecomb.springstatusmachine.demo;

import cn.ecomb.springstatusmachine.demo.demo.Events;
import cn.ecomb.springstatusmachine.demo.demo.States;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class StateStartApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(StateStartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StateStartApplication.class, args);
		logger.info("--->Start success");
	}

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Override
	public void run(String... args) throws Exception {
		stateMachine.start();
//		stateMachine.sendEvent(Events.PAY);
//		stateMachine.sendEvent(Events.RECEIVE);
	}

}
