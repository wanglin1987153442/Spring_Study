## 1.项目结构

> 注意建包的时候的层级
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120648.png)

## 2.数据库属性文件配置

> 注意几个属性的作用
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120719.png)

## 3.Spring主配置文件

- 开启注解扫描
- 读入外部数据库属性文件
- 配置数据源
- 配置JdbcTemplate
  ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120732.png)

## 4.sql脚本

> 尝试用脚本来建表
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120747.png)

## 5.实体类

> 尤其要注意，加了@Builder注解后，默认的无参构造器会失效，务必加上全参和无参构造器注解
> @AllArgsConstructor和@NoArgsContrutor
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120858.png)

## 6.ForumDao接口

> 声明基本的增删改查方法
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317122911.png)

## 7.ForumDao接口实现类

> 注意批量操作和查询的写法
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317123024.png)

## 8.单元测试

> 自己注意数据的一致性和断言的使用,建议测试顺序如下

- 单个新增
- 批量新增
- 查询所有
- 查询单个
- 修改单个（先查到再修改）
- 删除单个
  ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317124250.png)



# 小结



## 1   注解

@Repository 将Dao类声明为bean类   @autowrite 才可以调用 

## 2 xml文件执行步骤

xml扫描类 配置 

```
  //开启注解  才能扫描
  <context:annotation-config/>
    <context:component-scan base-package="com.wl.SpringStudy.ioc"/>
    //通过 读取resouce 下db.properties
    <contest:property-placeholder location="db.properties"/>
    配置数据元
     <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
          init-method="init">
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="initialSize" value="8"/>
    </bean>
    
    
    配置jdbc模板 
    
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>
```

## 3  jdbc模板

jdbcTemplate

增删改都用 update

查询用    queery 

## 4   断言

assert判断函数 

assertEquals(expected,actual)  和 assertNotEquals(expected,actual);
比较实际值与预期值是否一致。如果一致，程序继续运行，否则抛出异常，会打印报错信息。常用断言方法，便于调试。

2.assertTrue(message,condition) 和 assertFalse(message,condition)
如果条件的真假与预期相同，程序继续运行，否则抛出异常，不会打印报错信息。

3.assertNull(message,object) 和 assertNotNull(message,object)
判断一个对象是否为空，如果结果与预期相同，程序继续运行，否则抛出异常。

4**assertSame(**expected,actual**) 和 assertNotSame(**expected,actual**)**

判断预期的值和实际的值是否为同一个参数(即判断是否为相同的引用)，如果结果与预期相同，程序继续运行，否则抛出异常。

## 5

模糊查询列子

```
 public List<TPost> selectByKey(String key) {
        String sql = "select * from t_post where " +
                "title like CONCAT('%', ?, '%') " +
                "or content like CONCAT('%', ?, '%') " +
                "or thumbnail like CONCAT('%', ?, '%') ";
        Object[] args = {key, key, key};

        return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(TPost.class));
    }
```

批量查询 

```
 public int[] bathInsert(List<TPost> posts) {
        final List<TPost> postList = posts;
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setLong(1, postList.get(i).getForumId());
                preparedStatement.setString(2, postList.get(i).getTitle());
                preparedStatement.setString(3, postList.get(i).getContent());
                preparedStatement.setString(4, postList.get(i).getThumbnail());
                preparedStatement.setTimestamp(5, postList.get(i).getCreateTime());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }
```

3.19:
# 无xml化总结

1  首先 @configration配置类  装配 datasource 和  jdbc template   

通过 set方法 注入 对应值  这样 配置类写好 

```
@Configuration //标明配置类
@ComponentScan("com.wl.SpringStudy.ioc")
public class JDBCConfig {


    @Bean  //@Bean是一个方法级别上的注解，主要用在@Configuration注解的类里，也可以用在@Component注解的类里。添加的bean的id为方法名
    public DruidDataSource druidDataSource(){
    //创建对象
DruidDataSource druidDataSource =new DruidDataSource();
//
SET传值
druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
druidDataSource.setUrl("jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
druidDataSource.setUsername("root");
druidDataSource.setPassword("root");
druidDataSource.setInitialSize(8);

        return  druidDataSource;
    }

```
3.19
1  首先 @configration配置类  装配 datasource 和  jdbc template   

通过 set方法 注入 对应值  这样 配置类写好 

@Configuration //标明配置类
@ComponentScan("com.wl.SpringStudy.ioc")
public class JDBCConfig {


    @Bean  //@Bean是一个方法级别上的注解，主要用在@Configuration注解的类里，也可以用在@Component注解的类里。添加的bean的id为方法名
    public DruidDataSource druidDataSource(){
    //创建对象
DruidDataSource druidDataSource =new DruidDataSource();
//
SET传值
druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
druidDataSource.setUrl("jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
druidDataSource.setUsername("root");
druidDataSource.setPassword("root");
druidDataSource.setInitialSize(8);

        return  druidDataSource;
    }
2  扫包  @componetScan 扫包注解 确保 注解都能扫到  

dao层、service层、controller层
可以用不同的注解
@Repository
@Service

@Controller

@Component可以统一代替

3： 测试类引用时 @ContextConfigration(class={xxxx.class }) 


事务处理三个步骤：

数据库设置不自动提交

开启事务

数据库commit 设置为true

exception 放（rollback（））

joda Time 库 时间处理 

java jsoup 爬虫

HTTp client  库 做请求工具   

json Jackson  Fastjson   



3.31
typora

数据持久化技术

jdbc  

JPA规范 

java Persistance API java持久化应用程序化接口

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/img/Snipaste_2020-04-01_20-45-52.jpg)

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/img/Snipaste_2020-04-01_20-45-52.jpg)



2020.41

完成工作 webxml  web-annotation  mybatis-xml  Mybatis-anotion  jdbc xml  jdbc-annotation 版 
详情看文档注释 
总结：

总结：

xml配置所需要

统一配置datasource   jdbc properties 不可或缺

```
 <!--扫描含有注解的包-->
    <context:component-scan base-package="com.Spring_Study.mybatis.service.impl"/>
     <!-- 启动上下文的注解配置 -->
    <context:annotation-config/>
    <!-- 启动AOP支持 -->
    <aop:aspectj-autoproxy/>
    
    
```

jdbcTemplate

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/img/Snipaste_2020-04-01_20-48-19.jpg)

头注解区别测试类：![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/img/Snipaste_2020-04-01_20-48-29.jpg)



web-xml

配置仍旧是jdbc template

web 文件 执行核心文件在 

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/img/Snipaste_2020-04-01_20-48-38.jpg)

注意：servlet的配置 设置优先级 以及资源的目录设置

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/img/Snipaste_2020-04-01_20-48-44.jpg)

指定资源位置 不然直接加载WEB-INF 

视图对象 后端Thymleaf

mybatis版本配置：

```
    <!-- 在springIOC容器中创建mybatis核心类sqlSessionFactor -->
    <bean id="sqlSessionFactory"
          class="org.mybatis.spring.SqlSessionFactoryBean">
        <!-- 需要 dataSource -->
        <property name="dataSource" ref="dataSource"/>
        <!-- 引入mybatis配置文件 -->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <!--指定实体类所在包-->
        <property name="typeAliasesPackage" value="com.Spring_Study.mybatis.entity"/>
        <!-- 自动扫描mapping.xml文件 -->
        <property name="mapperLocations" value="classpath:mappers/*.xml"/>
    </bean>

    <!-- 通过Mapper扫描器MapperScannerConfigurer，批量将 basePackage指定包中的接口全部生成Mapper动态代理对象 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.Spring_Study.mybatis.mapper"/>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory">
        </property>
    </bean>

    <!--事务管理器配置 -->
    <bean id="manager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
          p:dataSource-ref="dataSource"/>
```



mybatis-config就是代码改掉  改成注解版

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/img/Snipaste_2020-04-01_20-48-59.jpg)

mybatis 注意官网 ：<https://mybatis.org/mybatis-3/zh/index.html>







![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/img/Snipaste_2020-04-01_20-49-08.jpg)



![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/img/Snipaste_2020-04-01_20-49-13.jpg)

注解：

@Configuration 等同于spring的XML配置文件；使用Java代码可以检查类型安全。

@EnableAutoConfiguration 自动配置。

@ComponentScan 组件扫描注解用

@Autowired自动导入。  @Resource

@PathVariable获取参数。

@Value注解 取出properties文件中的配置值。@Value(“${wx_appid}”)

@Controller, @Service, @Repository,@Component

@RequestBody

[@RequestParam作用是提取和解析请求中的参数

### @PathVariable，@RequestHeader，@RequestParam, @RequestBody

@Target：定义注解的作用目标:

[.@RequestMapping](mailto:23.@RequestMapping)处理映射请求的注解

# SQL

@insert @select @delete @uodate

```
@Options(useGeneratedKeys = true, keyProperty = "studentId")
``````