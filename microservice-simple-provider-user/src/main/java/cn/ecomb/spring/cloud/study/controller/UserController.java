package cn.ecomb.spring.cloud.study.controller;

import cn.ecomb.spring.cloud.study.entity.User;
import cn.ecomb.spring.cloud.study.repository.UserReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouzhigang on 2017/6/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserReository userReository;

  @GetMapping("/{id}")
  public User findUser(@PathVariable("id") Long id) {
    return userReository.findOne(id);
  }

  @GetMapping("/s")
  public String  findSting() {
    return "string";
  }

}
