package com.wym.phoneinfo.utils;


import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConf {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer =new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlsessionFactorybean");
        mapperScannerConfigurer.setBasePackage("com.wym.phoneinfo.dao");
        return mapperScannerConfigurer;
    }
}
