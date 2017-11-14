package cn.ecomb.springcache.demo.support.exception;

import cn.ecomb.springcache.demo.support.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * 全局异常处理切面
 *
 * @author zhouzhigang
 * @date 2017/11/13.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 所有系统异常拦截处理
     *
     * @param ex
     * @param req
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(final Exception ex, final WebRequest req) throws Exception {
        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) {
            throw ex;
        }
        logger.error("server error info: {}", ex);
        ex.printStackTrace();
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setCode(50001)
                .setMessage("服务器异常，有程序猿要扣年终奖啦！")
                .setDeveloperMessage(ex.getMessage());
        return new ResponseEntity<Object>(responseBody, HttpStatus.OK);
    }

}
