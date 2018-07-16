package cn.ecomb.springcache.demo.support.validation;

/**
 * @auth: zhouzg
 * @date: 2018/7/16
 */
public enum ExceptionCode {

    /** 不能为空 */
    NULL(10001, "不能为空"),
    ;

    ExceptionCode() {
    }

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;


}
