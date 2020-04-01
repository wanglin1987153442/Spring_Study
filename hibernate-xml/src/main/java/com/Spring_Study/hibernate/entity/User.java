package com.Spring_Study.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author 林小派
 */
@Entity    //标识该类是Hibernate的实体类，最好实现序列化接口
@Table(name="t_user")//正向工程生成数据表的表名
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id            //声明属性为主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)	//主键自增
    @Column(name="user_id")	//数据库字段和类属性映射关系
    private Integer userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="age")
    private Integer age;

}