package com.Spring_Study.ioc.entity;


import lombok.Data;

import java.util.List;

/**
 * @author wl
 * @ClassNameStudent
 * @Description TODO
 * @Date 2020/3/12
 * @Version 1.0
 */
@Data
public class Student {
    private String name;
    private String age;
    private List<String> hobbies;
    private List<Phone> phone;
}