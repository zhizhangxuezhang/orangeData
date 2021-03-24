package com.chuangshu.orange_data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chuangshu.orange_data.dao")
public class OrangeDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeDataApplication.class, args);
    }

}
