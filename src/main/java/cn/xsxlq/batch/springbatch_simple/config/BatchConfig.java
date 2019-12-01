package cn.xsxlq.batch.springbatch_simple.config;

import cn.xsxlq.batch.springbatch_simple.comm.Common;
import cn.xsxlq.batch.springbatch_simple.job.process.BatchProcess;
import cn.xsxlq.batch.springbatch_simple.job.reader.BatchReader;
import cn.xsxlq.batch.springbatch_simple.job.writer.BatchWriter;
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
public class BatchConfig {

//    @Resource(name = "batchSqlSessionTemplate")
//    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Autowired
    private BatchProcess batchWorldProcess;

    @Autowired
    private BatchWriter batchWorldWriter;

    @Autowired
    private BatchReader batchReader;


    @Bean
    public Job batchWorldJob(){
        return jobBuilderFactory.get("batchWorldJob")
                .start(batchWorldStep())
                .build();
    }

    @Bean
    public Step batchWorldStep(){
        return stepBuilderFactory.get("batchWorldStep")
                .chunk(Common.chunkCount)
                .reader(batchReader)
                .processor(batchWorldProcess)
                .writer(batchWorldWriter)
                .build();
    }

//    @Bean
//    @StepScope
//    public BatchReader batchWorldReader(){
//        return new BatchReader(sqlSessionTemplate);
//    }
}
