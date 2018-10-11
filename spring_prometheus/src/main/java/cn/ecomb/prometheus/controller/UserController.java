package cn.ecomb.prometheus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouzhigang on 2017/10/27.
 */
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *
     * @return
     */
    @GetMapping("/test")
   public String test() {
        return "hello";
   }

}
