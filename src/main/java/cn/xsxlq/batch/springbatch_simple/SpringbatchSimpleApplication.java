package cn.xsxlq.batch.springbatch_simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.xsxlq.batch.springbatch_simple.dao")
public class SpringbatchSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbatchSimpleApplication.class, args);
    }

}
