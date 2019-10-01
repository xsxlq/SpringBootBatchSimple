package cn.xsxlq.batch.springbatch_simple.job.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/10/1 14:07
 */
@Component
public class HelloWorldWriter implements ItemWriter {

    @Override
    public void write(List items) throws Exception {
        items.forEach(System.out::println);
    }
}
