package cn.ecomb.springcache.demo.support.exception.custom;

/**
 * 校验类异常
 * 如果有更细的校验异常，继承此类
 *
 * @author zhouzhigang
 * @date 2017/11/14.
 */
public class ValidationException extends AbstractException {

    public ValidationException(int code, String message) {
        super(code, message);
    }

    public ValidationException(int code, String message, String developerMessage) {
        super(code, message, developerMessage);
    }
}
