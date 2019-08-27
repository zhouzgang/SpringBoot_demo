package cn.ecomb.kafka;

import cn.ecomb.kafka.exception.custom.WebException;
import cn.ecomb.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouzg
 * @date 2018/9/25
 */
@RestController
public class KafkaProducer {

    @Autowired
    Sender sender;

    @RequestMapping(value = "/sender", method = RequestMethod.POST)
    public void exec(HttpServletRequest request, HttpServletResponse response, String data) throws IOException {
//        this.sender.send("testtopic",data);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/json");
//        response.getWriter().write("success");
//        response.getWriter().flush();
//        response.getWriter().close();
        throw new WebException(123, "fa");
    }

}
