package cn.ecomb.spring.batch.config;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/4/23.
 */
public class LogItemWriter<T> implements ItemWriter<T> {
    @Override
    public void write(List<? extends T> items) throws Exception {
        
    }
}
