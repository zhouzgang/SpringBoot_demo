package cn.ecomb.service;

import org.springframework.stereotype.Service;

/**
 * @author zhouzg
 * @date 2019/1/23
 */
@Service
public class UserService extends UserServiceAbstract {

    public String getStr() {
        return "abcd";
    }
}
