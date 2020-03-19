package com.Spring_Study.ioc.util;


import com.Spring_Study.ioc.config.StudentConfig;
import com.Spring_Study.ioc.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/beans.xml"})
@ContextConfiguration(classes = StudentConfig.class)
public class StudentTest {
    @Autowired
    private Student student;

    @Test
    public void test(){
        System.out.println(student);

    }

}