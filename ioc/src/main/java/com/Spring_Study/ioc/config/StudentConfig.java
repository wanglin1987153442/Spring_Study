package com.Spring_Study.ioc.config;


import com.Spring_Study.ioc.entity.Phone;
import com.Spring_Study.ioc.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wl
 * @ClassNameStudentConfig
 * @Description TODO
 * @Date 2020/3/19
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.Spring_Study.ioc")
public class StudentConfig {
    @Bean
    public Student student() {
        Student student = new Student();
        student.setAge("19");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("爬山");
        hobbies.add("洗衣服");
        hobbies.add("STUDY");
        student.setHobbies(hobbies);
        Phone phone1 = new Phone();
        phone1.setPhone("iphone");
        phone1.setPrice(12312);

        List<Phone> phones = new ArrayList<>();
        phones.add(phone1);
      student.setPhone(phones);
      return student;
    }
}
