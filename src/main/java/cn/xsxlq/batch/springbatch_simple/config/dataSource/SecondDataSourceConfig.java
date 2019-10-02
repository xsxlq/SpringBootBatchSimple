package cn.xsxlq.batch.springbatch_simple.config.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 第二数据源
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/10/2 18:27
 */
@Configuration
public class SecondDataSourceConfig {
    @Bean(name = "marketDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.market")
    public DataSource getDateSource2() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "marketSqlSessionFactory")
    public SqlSessionFactory batchSqlSessionFactory(@Qualifier("marketDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapping/*.xml"));
        return bean.getObject();
    }


    @Bean("marketSqlSessionTemplate")
    public SqlSessionTemplate batchSqlsessiontemplate(
            @Qualifier("marketSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
