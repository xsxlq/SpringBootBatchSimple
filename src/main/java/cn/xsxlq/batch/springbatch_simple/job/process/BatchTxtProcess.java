package cn.xsxlq.batch.springbatch_simple.job.process;

import cn.xsxlq.batch.springbatch_simple.pojo.ShopGoodsType;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/12/1 17:47
 */
@Component
public class BatchTxtProcess implements ItemProcessor<ShopGoodsType,ShopGoodsType> {
    @Override
    public ShopGoodsType process(ShopGoodsType item) throws Exception {
        System.out.println("process:"+item);
        return item;
    }
}
