package cn.ecomb.springcache.demo.support.exception.custom;

/**
 * service 层异常
 *
 * @author zhouzhigang
 * @date 2017/11/14.
 */
public class ServiceException extends AbstractException {

    public ServiceException(int code, String message) {
        super(code, message);
    }

    public ServiceException(int code, String message, String developerMessage) {
        super(code, message, developerMessage);
    }
}
