package com.Spring_Study.webx.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.security.PublicKey;

/**
 * @author su
 * @className JDBCConfig
 * @Description TODO
 * @Date 2020/3/19 8:16
 * @Version 1.0
 **/

@Configuration
@ComponentScan("com.Spring_Study.webx")
//指定web资源
@WebAppConfiguration("src/main/resources")
//指定资源
@PropertySource("classpath:db.properties")
//开启注解
@EnableTransactionManagement
public class JDBCConfig {
    @Value("com.mysql.jdbc.Driver")
    private String driverClassName;
    @Value("jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf8&useSSL=false&autoR")
    private String jdbcUrl;
    @Value("root")
    private String username;
    @Value("root")
    private String password;

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(jdbcUrl);
        //配置最大化最小连接数
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        //配置获取连接等待时间
        druidDataSource.setMaxWait(60000);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(1);
        //设置连接池最小存活时间
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        //关闭自动提交
        druidDataSource.setDefaultAutoCommit(false);
        //设置连接池启动事务处理
        druidDataSource.setPoolPreparedStatements(true);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) {
        return new JdbcTemplate(druidDataSource);
    }
/**
 * 装配事务 配置事务
 */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource){
        return new DataSourceTransactionManager(druidDataSource);
    }
}
