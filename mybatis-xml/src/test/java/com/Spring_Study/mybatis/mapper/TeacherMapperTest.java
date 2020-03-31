package com.Spring_Study.mybatis.mapper;

import com.Spring_Study.mybatis.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author wl
 * @ClassNamesad
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class TeacherMapperTest {

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    public void getTeacherOneToOne() {
        Teacher teacher = teacherMapper.getTeacherOneToOne(1);
        System.out.println(teacher.getTeacherId() + "," + teacher.getTeacherName() +
                "," + teacher.getClazz().getClazzId() + "," + teacher.getClazz().getClazzName());
    }
}