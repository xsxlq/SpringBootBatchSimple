package cn.xsxlq.batch.springbatch_simple.config;

import cn.xsxlq.batch.springbatch_simple.comm.Common;
import cn.xsxlq.batch.springbatch_simple.job.process.BatchTxtProcess;
import cn.xsxlq.batch.springbatch_simple.job.reader.FlatFileTxtItemReader;
import cn.xsxlq.batch.springbatch_simple.job.writer.BatchTxtWriter;
import cn.xsxlq.batch.springbatch_simple.pojo.ShopGoodsType;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangjs6
 * @version 1.0
 * @Description:
 * @date: 2019/12/1 17:45
 */
@Configuration
public class BatchTxtConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private BatchTxtProcess batchTxtProcess;

    @Autowired
    private BatchTxtWriter batchTxtWriter;

    @Bean
    public Job batchTxtJob(){
        return jobBuilderFactory.get("batchTxtJob")
                .start(batchTxtStep())
                .build();
    }

    @Bean
    public Step batchTxtStep(){
        return stepBuilderFactory.get("batchTxtStep")
                .<ShopGoodsType,ShopGoodsType>chunk(Common.chunkCount)
                .reader(batchTxtReader())
                .processor(batchTxtProcess)
                .writer(batchTxtWriter)
                .build();
    }
    @Bean
    @StepScope
    public FlatFileTxtItemReader batchTxtReader(){
        return new FlatFileTxtItemReader(ShopGoodsType.class);
    }
}
