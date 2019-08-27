package cn.ecomb.springhttp.demo.controller;

import cn.ecomb.springhttp.demo.controller.vo.resp.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
        UserVO userVO = restTemplate.getForObject("http://lx2.test.papakaka.com/api/movie/1561",
                UserVO.class);
        logger.info("----->result: {}", userVO);

        return userVO;
    }

    @GetMapping("/t")
    public List<UserVO> RestTemplate() {
        UserVO userVO = new UserVO();
        userVO.setAge(1);
        userVO.setId(12L);
        userVO.setName("fdsafs");
        userVO.setUsername("fdsafs");
        UserVO userVO1 = new UserVO();
        userVO1.setAge(2);
        userVO1.setId(12L);
        userVO1.setName("fdsaf21221122s");
        userVO1.setUsername("22222");
        List list = new ArrayList();
        list.add(userVO);
        list.add(userVO1);
        logger.info("hahahhahahahahahahahahahhahahah");
        return list;
    }



    @Autowired
    private RestTemplate restTemplate;
}
