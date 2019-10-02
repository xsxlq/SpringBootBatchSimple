package cn.xsxlq.batch.springbatch_simple.config;

import cn.xsxlq.batch.springbatch_simple.comm.Common;
import cn.xsxlq.batch.springbatch_simple.job.process.HelloWorldProcess;
import cn.xsxlq.batch.springbatch_simple.job.reader.HelloWorldReader;
import cn.xsxlq.batch.springbatch_simple.job.writer.HelloWorldWriter;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/10/1 14:05
 */
@Configuration
@EnableBatchProcessing
public class HelloWordConfig {

    @Resource(name = "batchSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Autowired
    private HelloWorldProcess helloWorldProcess;

    @Autowired
    private HelloWorldWriter helloWorldWriter;


    @Bean
    public Job helloWorldJob(){
        return jobBuilderFactory.get("helloWorldJob")
                .start(helloWorldStep())
                .build();
    }

    @Bean
    public Step helloWorldStep(){
        return stepBuilderFactory.get("helloWorldStep")
                .chunk(Common.chunkCount)
                .reader(helloWorldReader())
                .processor(helloWorldProcess)
                .writer(helloWorldWriter)
                .build();
    }

    @Bean
    @StepScope
    public HelloWorldReader helloWorldReader(){
        return new HelloWorldReader(sqlSessionTemplate);
    }
}
