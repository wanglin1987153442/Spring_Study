package com.Spring_Study.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseStudent {

  private Integer id;
  private Integer courseId;
  private Integer studentId;



}
