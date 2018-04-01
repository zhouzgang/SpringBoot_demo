package cn.ecomb.shrio.realm;

import cn.ecomb.shrio.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhouzhigang
 * @date 2018/3/8.
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        authorizationInfo.addStringPermission("quanxianStr");
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        User user = (User) authenticationToken.getPrincipal();
        /**
         * 这里写用户用户认证逻辑
         */
//        User user = new User();
        user.setAccount("123456");
        user.setPassword("123456");
        user.setName("zhangsan");

        logger.info("------->认证, {}", authenticationToken);

//        如果认证不通过就返回空，退出
//        if (user != null) {
//            return null;
//        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,
                user.getPassword(),
                user.getName());

        return authenticationInfo;
    }
}
