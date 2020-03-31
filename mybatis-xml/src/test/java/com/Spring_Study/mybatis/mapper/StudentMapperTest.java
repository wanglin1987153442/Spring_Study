package com.Spring_Study.mybatis.mapper;

import com.Spring_Study.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})

public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;
    @Test
    @Transactional
    @Rollback(true)
    public void insert() {
        Student student = Student.builder().clazzId(1).studentName("测试学生").hometown("浙江温州")
                .birthday(LocalDate.of(2000, 10, 10))
                .build();
        studentMapper.insert(student);
        System.out.println(student.getStudentId());
    }
    @Test
    @Transactional
    @Rollback(true)
    public void delete() {
        studentMapper.delete(2013);
        System.out.println("成功");

    }
    @Test
    @Transactional
    @Rollback(true)
    public void update() {
        Student student = Student.builder().studentId(2008).hometown("北京").build();
        studentMapper.update(student);
    }
    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder().studentId(4000 + i).hometown("测试城市").studentName("测试" + i).clazzId(1).birthday(LocalDate.of(1999, 01, 01)).build();
            students.add(student);
        }
        System.out.println(studentMapper.batchInsert(students));
    }
    @Test
    public void batchDelete() {
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int n = 4000 + i;
            idList.add(n);
        }
        System.out.println(idList);
        studentMapper.batchDelete(idList);
//        System.out.println(studentMapper.batchDelete(idList));
    }
    @Test public void batchUpdate(){
        List<Student> list = new ArrayList<>();
        for (int i=1;i<6;i++){
            Student student =Student.builder()
                    .studentId(4000+i)
                    .studentName("测试44"+i)
                    .clazzId(3).build();
            list.add(student);
        }
        int n =studentMapper.batchUpdate(list);
        System.out.println(n);
    }
    @Test
    public  void  selectLimit(){
        System.out.println(studentMapper.selectLimit());
    }

@Test
    public void selectAll(){
        List<Student>students=studentMapper.selectAll();
        students.forEach(student -> {
            System.out.println(student.getStudentId()

            +","+student.getStudentName()
                            +","+ student.getHometown()
                            +","+student.getBirthday()
                            +","+student.getClazz().getClazzName()
            );
        });
}
}