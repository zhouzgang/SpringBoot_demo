package cn.ecomb.kafka;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author zhouzg
 * @date 2018/9/25
 */
public interface Formatter {
    String format(ILoggingEvent event);
}
