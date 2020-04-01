package com.Spring_Study.mybatis.mapper;

import com.Spring_Study.mybatis.config.MapperConfig;
import com.Spring_Study.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MapperConfig.class})
public class StudentMapperTest {
@Resource
private StudentMapper studentMapper;
    @Test
    public void selectAll() {
        System.out.println(studentMapper.selectAll());
    }
    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Student student = Student.builder()
                    .studentName("学生" + i)
                    .clazzId(1)
                    .hometown("测试城市")
                    .birthday(LocalDate.of(2000, 12, 12))
                    .build();
            students.add(student);
        }
        studentMapper.batchInsert(students);
    }
}