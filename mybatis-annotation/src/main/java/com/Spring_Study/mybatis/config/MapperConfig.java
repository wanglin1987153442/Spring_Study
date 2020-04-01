package com.Spring_Study.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wl
 * @ClassNameMapperConfig
 * @Description mybatis注解版
 * @Date 2020/4/1
 * @Version 1.0
 */
//标明注解配置类
@Configuration
//扫包
@MapperScan(value = "com.Spring_Study.mybatis.mapper")
//配置数据库资源文件
@PropertySource("classpath:db.properties")
//
@EnableAspectJAutoProxy(proxyTargetClass = true)
//开启事务注解
@EnableTransactionManagement
public class MapperConfig {
    @Value("com.mysql.jdbc.Driver")
    private String driverClassName;
    @Value("jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf8&useSSL=false&autoR")
    private String jdbcUrl;
    @Value("root")
    private String username;
    @Value("root")
    private String password;

    /**
     * 数据连接地址池配置
     *
     * @return druidDataSource
     */
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
    //调用sqlSessionFactory
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    /**
     * 装配MyBatis的SqlSessionFactory
     * //相当于底层jdbc connection  不可或缺 去控制 增删改查 以及事务管理类似于一个管家
     *
     * @return SqlSessionFactory
     * @throws Exception
     */
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        //配置数据源
        sessionFactoryBean.setDataSource(dataSource());
        //指定xml文件路径
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));
        // 开启开启驼峰命名转换
        sessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        //产生对象是调用sessionFactory.getObject()方法
        return sessionFactoryBean.getObject();
    }


    /**
     * 装配事务管理器
     *
     * @return DataSourceTransactionManager
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dtc = new DataSourceTransactionManager();
        dtc.setDataSource( dataSource());
        return dtc;
    }

}
