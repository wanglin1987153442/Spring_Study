package com.Spring_Study.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {

  private Integer courseId;
  private String courseName;
private List<Student>students;

}
