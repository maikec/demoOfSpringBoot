package com.example.springboot.config;
/**
 * 公司名称
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/10
 */
@SpringBootConfiguration
@MapperScans(value = {
        @MapperScan(value = "com.example.springboot.repository.mapper"),
        @MapperScan(value = "com.example.springboot.repository.mapperext",sqlSessionTemplateRef = "defaultSqlSession")
})

public class MybatisConfig {
    @Bean
    public SqlSessionFactory masterSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(defaultDataSource());
        factoryBean.setVfs(SpringBootVFS.class);
        return factoryBean.getObject();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    @Primary
     public DataSource dataSource() {
        return DataSourceBuilder.create().build();
     }

     @Bean
     @ConfigurationProperties("spring.datasource")
     public DataSource defaultDataSource() {
        return DataSourceBuilder.create().build();
     }
     @Bean
     @Primary
     public DataSourceTransactionManager transactionManager() {
       return new DataSourceTransactionManager(dataSource());
     }
     @Bean
     public DataSourceTransactionManager defaultTransactionManager() {
       return new DataSourceTransactionManager(defaultDataSource());
     }
     @Bean
     @Primary
     public SqlSessionFactory sqlSessionFactory() throws Exception {
       SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
       sessionFactory.setDataSource(dataSource());
       return sessionFactory.getObject();
     }

     @Bean
    public SqlSessionTemplate defaultSqlSession() throws Exception{
         return new SqlSessionTemplate(masterSqlSessionFactory(), ExecutorType.BATCH);
     }
     @Bean
     @Primary
    public SqlSessionTemplate sqlSession() throws Exception{
         return new SqlSessionTemplate(sqlSessionFactory(), ExecutorType.BATCH);
     }
}
