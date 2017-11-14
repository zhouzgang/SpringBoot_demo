package cn.ecomb.springcache.demo.support.exception.custom;

/**
 * 自定义异常的父类
 *
 * @author zhouzhigang
 * @date 2017/11/14.
 */
public abstract class AbstractException extends RuntimeException{

    /**
     * 异常状态码
     */
    private int code;

    /**
     * 返回用户错误信息
     */
    private String message;

    /**
     * 返回开发者错误信息
     */
    private String developerMessage;

    public AbstractException() {
        super();
    }

    public int getCode() {
        return code;
    }

    public AbstractException setCode(int code) {
        this.code = code;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public AbstractException setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public AbstractException setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }
}
