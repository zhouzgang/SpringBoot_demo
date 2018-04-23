package cn.ecomb.spring.batch.config;

import cn.ecomb.spring.batch.entity.Person;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author zhouzhigang
 * @date 2018/4/20.
 */
public class MyItemProcessor implements ItemProcessor<Person, Person>{
    @Override
    public Person process(Person item) throws Exception {
        item.setFirstName(item.getFirstName() + item.getLastName());
        return item;
    }
}
