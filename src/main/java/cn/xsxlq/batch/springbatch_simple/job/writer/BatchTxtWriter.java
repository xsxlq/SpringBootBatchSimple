package cn.xsxlq.batch.springbatch_simple.job.writer;

import cn.xsxlq.batch.springbatch_simple.pojo.ShopGoodsType;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/12/1 17:49
 */
@Component
public class BatchTxtWriter implements ItemWriter<ShopGoodsType> {
    @Override
    public void write(List<? extends ShopGoodsType> items) throws Exception {
        System.out.println("write:"+items);
    }
}
