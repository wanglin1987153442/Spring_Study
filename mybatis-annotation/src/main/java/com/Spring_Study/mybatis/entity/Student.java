package com.Spring_Study.mybatis.entity;


import com.Spring_Study.mybatis.entity.Clazz;
import com.Spring_Study.mybatis.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 林小派
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    /**
     * 学生id，主键
     */
    private Integer studentId;
    /**
     * 所属班级id
     */
    private Integer clazzId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 学生籍贯
     */
    private String hometown;
    /**
     * 学生出生日期
     */
    private LocalDate birthday;
    /**
     * 学生所属班级
     */
    private Clazz clazz;
    private List<Course> courses;

    public Student(String studentName) {
        this.studentName = studentName;
    }
}
