package cn.ecomb.springcache.demo.support.validation;

import cn.ecomb.springcache.demo.support.exception.custom.ValidationException;

/**
 * 校验封装
 *
 * @auth: zhouzg
 * @date: 2018/7/16
 */
public class Validation {


    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new ValidationException(1, message);
        }
    }

    public static void isNull(Object object) {
        isNull(object, "the object argument must be null");
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new ValidationException(2, message);
        }
    }


}
