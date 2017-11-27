package cn.ecomb.springhttp.demo.controller;

import cn.ecomb.springhttp.demo.controller.vo.resp.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhouzhigang
 * @date 2017/11/26.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping
    public UserVO testRestTemplate() {
        UserVO userVO = restTemplate.getForObject("http://127.0.0.1:8000/user/{userId}",
                UserVO.class,
                "1");
        logger.info("----->result: {}", userVO);
        return userVO;
    }

    @Autowired
    private RestTemplate restTemplate;
}
