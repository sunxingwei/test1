/*
package com.example.demo.config;




import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
//@MapperScan("com.example.demo.*.*mapper*")
@MapperScan("com.example.demo.mapper")
public class MybatisPlusConfig {

   @ConfigurationProperties(prefix = "spring.datasource")
   @Bean
   public DataSource dataSource() {
      DruidDataSource dataSource = new DruidDataSource();
      dataSource.setInitialSize(5);
      dataSource.setMaxActive(30);
      dataSource.setMinIdle(5);
      dataSource.setMaxWait(60000);
      return dataSource;
   }

   // 配置事物管理器
   @Bean(name="transactionManager")
   public DataSourceTransactionManager transactionManager(){
      return new DataSourceTransactionManager(dataSource());
   }

   */
/***
    * plus 的性能优化
    * @return
    *//*

   @Bean
   public PerformanceInterceptor performanceInterceptor() {
      PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        */
/*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*//*

      performanceInterceptor.setMaxTime(1000);
        */
/*<!--SQL是否格式化 默认false-->*//*

      performanceInterceptor.setFormat(true);
      return performanceInterceptor;
   }

   */
/**
    * @Description : mybatis-plus分页插件
    * ---------------------------------
    * @Author : Liang.Guangqing
    * @Date : Create in 2017/9/19 13:59
    *//*

   @Bean
   public PaginationInterceptor paginationInterceptor() {
      return new PaginationInterceptor();
   }

}*/
