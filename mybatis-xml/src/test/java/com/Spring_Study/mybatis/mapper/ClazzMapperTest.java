package com.Spring_Study.mybatis.mapper;

import com.Spring_Study.mybatis.domain.ClazzVo;
import com.Spring_Study.mybatis.domain.MatterDto;
import com.Spring_Study.mybatis.domain.MatterVo;
import com.Spring_Study.mybatis.entity.Clazz;
import com.Spring_Study.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ClazzMapperTest {
    @Resource
    private ClazzMapper clazzMapper;

    @Test
    public void getClazzStudent() {
        List<ClazzVo> clazzVo = clazzMapper.getClazzStudent(1);
        clazzVo.forEach(System.out::println);
    }

    @Test
    public void getClazzTeacher() {
        List<Map<String, Object>> clazzVo = clazzMapper.getClazzStudent1(2);
        clazzVo.forEach(System.out::println);
    }

    @Test
    public void selectLimitFromTeacherInClassByDynamicSql() {
        MatterDto matterDto = MatterDto.builder().teacherName("许老师 ").clazzName("软件1851").student(new Student("王")).build();
   clazzMapper.selectLimitFromTeacherInClassByDynamicSql(matterDto).forEach(System.out::println);

    }

    @Test
    public void getClazzOneToMany() {
        Clazz clazz = clazzMapper.getClazzOneToMany(1);
        System.out.println(clazz.getClazzId() + "," + clazz.getClazzName());
        List<Student> students = clazz.getStudents();
        students.forEach(student -> {
            System.out.println(student.getStudentId() +
                    "," + student.getStudentName() +
                    "," + student.getHometown() +
                    "," + student.getBirthday());
        });
    }
}