package com.Spring_Study.ioc.util;

import com.Spring_Study.ioc.entity.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wl
 * @ClassNamePhoneTest
 * @Description TODO
 * @Date 2020/3/12
 * @Version 1.0
 */

public class PhoneTest {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        Phone phone=(Phone)ac.getBean("phone1");
        System.out.println(phone);
    }
}
