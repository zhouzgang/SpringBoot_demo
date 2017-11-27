package cn.ecomb.springcache.demo.controller.vo.req;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * @author zhouzhigang
 * @date 2017/11/22.
 */
public class UserParamVO {

    @NotBlank(message = "name不能为空")
    @Size(min=2, max=30, message = "名字长度必须在2和30之间")
    private String name;

    @DecimalMax(value = "150", message = "年龄不能超过150岁")
    @DecimalMin(value = "0", message = "年龄不能小于0岁")
//    @NotEmpty(message = "年龄不能为空")
    private Integer age;

    public String getName() {
        return name;
    }

    public UserParamVO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserParamVO setAge(Integer age) {
        this.age = age;
        return this;
    }
}
