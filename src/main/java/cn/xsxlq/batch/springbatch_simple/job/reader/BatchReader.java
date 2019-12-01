package cn.xsxlq.batch.springbatch_simple.job.reader;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/10/1 14:48
 */
@Component
public class BatchReader extends MyBatisPagingItemReader{

    @Resource(name = "batchSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @PostConstruct
    public void init(){
        setSqlSessionFactory(sqlSessionTemplate.getSqlSessionFactory());
        setQueryId("cn.xsxlq.batch.mapping.ShopGoodsTypeMapper.selectList");
        setPageSize(10);
    }

//    public BatchReader(SqlSessionTemplate sqlSessionTemplate){
//        setSqlSessionFactory(batchReader.sqlSessionTemplate.getSqlSessionFactory());
//        setQueryId("cn.xsxlq.batch.mapping.ShopGoodsTypeMapper.selectList");
//        setPageSize(10);
//    }
}
