package cn.xsxlq.batch.springbatch_simple.job.process;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/10/1 14:08
 */
@Component
public class HelloWorldProcess implements ItemProcessor {
    @Override
    public Object process(Object item) throws Exception {
        return item;
    }
}
