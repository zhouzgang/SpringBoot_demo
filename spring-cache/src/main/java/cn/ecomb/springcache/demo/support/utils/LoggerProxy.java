package cn.ecomb.springcache.demo.support.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志划分:
 *
 * 参考网址：http://tech.lede.com/2017/06/30/rd/server/loggingHabit/
 *
 * @auth: zhouzg
 * @date: 2018/7/16
 */
public enum LoggerProxy {

    /** 监控 */
    MONITOR,

    /** 默认 */
    DEFAULT;

    public Logger create(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
