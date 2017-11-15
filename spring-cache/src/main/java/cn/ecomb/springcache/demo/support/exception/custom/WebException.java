package cn.ecomb.springcache.demo.support.exception.custom;

/**
 * web 层异常
 *
 * @author zhouzhigang
 * @date 2017/11/14.
 */
public class WebException extends AbstractException {

    public WebException(int code, String message) {
        super(code, message);
    }

    public WebException(int code, String message, String developerMessage) {
        super(code, message, developerMessage);
    }
}
