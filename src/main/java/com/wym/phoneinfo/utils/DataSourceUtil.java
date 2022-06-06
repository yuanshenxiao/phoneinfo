package com.wym.phoneinfo.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceUtil {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlsessionFactorybean(){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        try{
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setTypeAliasesPackage("com.wym.phoneinfo.pojo");
            return sqlSessionFactoryBean.getObject();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

}
