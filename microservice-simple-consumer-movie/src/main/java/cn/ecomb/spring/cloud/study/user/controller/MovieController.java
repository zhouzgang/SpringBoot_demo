package cn.ecomb.spring.cloud.study.user.controller;

import cn.ecomb.spring.cloud.study.user.entity.User;
import cn.ecomb.spring.cloud.study.user.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhouzhigang on 2017/6/21.
 */
@RestController
public class MovieController {

//    ----- 使用 ribbon
//    @Autowired
//    private RestTemplate restTemplate;

//    @GetMapping("/user/{id}")
//    public User find(@PathVariable("id") Long id) {
//
//        return this.restTemplate.getForObject("http://microservice-simple-provider-user/user/" + id, User.class);
//    }
//
//
//    @GetMapping("/user/s")
//    public String finds() {
//
//        return this.restTemplate.getForObject("http://MICROSERVICE-SIMPLE-PROVIDER-USER/user/s", String.class);
//    }


//    ----- 使用 feign

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return this.userFeignClient.findById(id);
    }

}
