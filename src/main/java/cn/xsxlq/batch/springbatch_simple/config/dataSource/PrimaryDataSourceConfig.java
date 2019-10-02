package cn.xsxlq.batch.springbatch_simple.config.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * 主数据源配置
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/10/2 18:14
 */
@Configuration
// @MapperScan(basePackages = "com.mzd.multipledatasources.mapper.test01", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class PrimaryDataSourceConfig {

    @Bean(name = "batchDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.batch")
    public DataSource getDateSource1() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "batchSqlSessionFactory")
    @Primary
    public SqlSessionFactory batchSqlSessionFactory(@Qualifier("batchDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                        .getResources("classpath*:mapping/*.xml"));
        return bean.getObject();
    }


    @Bean("batchSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate batchSqlsessiontemplate(
            @Qualifier("batchSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}