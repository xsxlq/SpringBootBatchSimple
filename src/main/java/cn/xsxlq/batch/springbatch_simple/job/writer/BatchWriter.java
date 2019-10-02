package cn.xsxlq.batch.springbatch_simple.job.writer;

import cn.xsxlq.batch.springbatch_simple.pojo.ShopGoodsType;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/10/1 14:07
 */
@Component
public class BatchWriter implements ItemWriter {
    @Resource(name = "marketSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public void write(List items) throws Exception {
        sqlSessionTemplate.insert("cn.xsxlq.batch.mapping.ShopGoodsTypeMapper.insertSelective",
                (List<ShopGoodsType>)items);
    }
}
