package cn.xsxlq.batch.springbatch_simple.job.reader;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

/**
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/10/1 14:48
 */
public class BatchReader extends MyBatisPagingItemReader{

    public BatchReader(SqlSessionTemplate sqlSessionTemplate){
        setSqlSessionFactory(sqlSessionTemplate.getSqlSessionFactory());
        setQueryId("cn.xsxlq.batch.mapping.ShopGoodsTypeMapper.selectList");
        setPageSize(10);
    }
}
