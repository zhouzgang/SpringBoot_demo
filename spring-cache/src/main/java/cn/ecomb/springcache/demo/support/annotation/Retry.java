package cn.ecomb.springcache.demo.support.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author zhouzhigang
 * @date 2018/4/6.
 *
 * 接口失败，间隔后重试几次
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Retry {

    @AliasFor("value")
    String[] time() default "1";

//    @AliasFor("value")
    String[] interval() default "60000";

    String key() default "";
}
