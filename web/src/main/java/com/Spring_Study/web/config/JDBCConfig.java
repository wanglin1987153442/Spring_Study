package com.Spring_Study.web.config;


import com.Spring_Study.web.dao.ForumDao;
import com.Spring_Study.web.dao.impl.ForumDaoImpl;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author su
 * @className JDBCConfig
 * @Description TODO
 * @Date 2020/3/19 8:16
 * @Version 1.0
 **/

@Configuration
@ComponentScan("com.Spring_Study.web")
public class JDBCConfig {

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/db_bbs?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setInitialSize(1);
        return druidDataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }

//    @Bean
//    public ForumDao forumDao(JdbcTemplate jdbcTemplate){
//        return new ForumDaoImpl(jdbcTemplate);
//    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(JDBCConfig.class);
        DruidDataSource druidDataSource = (DruidDataSource) aca.getBean("dataSource");
        System.out.println(druidDataSource);
        JdbcTemplate jdbcTemplate = (JdbcTemplate) aca.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
    }
}
