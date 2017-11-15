package cn.ecomb.springcache.demo.support.exception;

import cn.ecomb.springcache.demo.support.ResponseBody;
import cn.ecomb.springcache.demo.support.exception.custom.ModuleException;
import cn.ecomb.springcache.demo.support.exception.custom.ServiceException;
import cn.ecomb.springcache.demo.support.exception.custom.ValidationException;
import cn.ecomb.springcache.demo.support.exception.custom.WebException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * 全局异常处理切面
 * HttpStatus: 500
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
     * @param ex    抛出的任何异常
     * @param req   当前请求
     * @return  返回封装后的异常，都以httpStatus：200 的形式
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAllExceptions(final Exception ex, final WebRequest req) throws Exception {
        this.throwIfResponseStatus(ex);
        logger.warn("request url: {}", req);
        logger.error("server error info: {}", ex);
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setCode(500)
                .setMessage("服务器异常，有程序猿要扣年终奖啦！")
                .setDeveloperMessage(ex.getStackTrace()[0].toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * 所有 service 层异常拦截处理
     *
     * @param ex    抛出的 ServiceException 异常
     * @param req   当前请求
     * @return  返回封装后的异常，都以httpStatus：200 的形式
     */
    @ExceptionHandler(value = {ServiceException.class})
    public ResponseEntity<Object> handleServiceException(final ServiceException ex, final WebRequest req)
            throws Exception {

        this.throwIfResponseStatus(ex);
        logger.warn("request url: {}", req);
        logger.error("server error info: ", ex);
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setCode(ex.getCode())
                .setMessage(ex.getMessage())
                .setDeveloperMessage(ex.getStackTrace()[0].toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * 所有 web 层异常拦截处理
     *
     * @param ex    抛出的 WebException 异常
     * @param req   当前请求
     * @return  返回封装后的异常，都以httpStatus：200 的形式
     */
    @ExceptionHandler(value = {WebException.class})
    public ResponseEntity<Object> handleWebException(final WebException ex, final WebRequest req)
            throws Exception {

        this.throwIfResponseStatus(ex);
        logger.warn("request url: {}", req);
        logger.error("Web Exception info: {}", ex);
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setCode(ex.getCode())
                .setMessage(ex.getMessage())
                .setDeveloperMessage(ex.getStackTrace()[0].toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * 所有不同的校验异常拦截处理
     *
     * @param ex    抛出的 ValidationException 异常
     * @param req   当前请求
     * @return  返回封装后的异常，都以httpStatus：200 的形式
     */
    @ExceptionHandler(value = {ValidationException.class})
    public ResponseEntity<Object> handleValidationException(final ValidationException ex, final WebRequest req)
            throws Exception {

        this.throwIfResponseStatus(ex);
        logger.warn("request url: {}", req);
        logger.error("Validation Exception info: {}", ex);
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setCode(ex.getCode())
                .setMessage(ex.getMessage())
                .setDeveloperMessage(ex.getStackTrace()[0].toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * 所有不同模块的异常拦截处理
     *
     * @param ex    抛出的 ModuleException 异常
     * @param req   当前请求
     * @return  返回封装后的异常，都以httpStatus：200 的形式
     */
    @ExceptionHandler(value = {ModuleException.class})
    public ResponseEntity<Object> handleModuleException(final ModuleException ex, final WebRequest req)
            throws Exception {

        this.throwIfResponseStatus(ex);
        logger.warn("request url: {}", req);
        logger.error("Module Exception info: {}", ex);
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setCode(ex.getCode())
                .setMessage(ex.getMessage())
                .setDeveloperMessage(ex.getStackTrace()[0].toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    private void throwIfResponseStatus(Exception ex) throws Exception {
        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) {
            throw ex;
        }
    }
}
