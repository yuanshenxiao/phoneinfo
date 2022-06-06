package com.wym.phoneinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.wym.phoneinfo.dao")
@EnableTransactionManagement
public class PhoneinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneinfoApplication.class, args);
    }

}
