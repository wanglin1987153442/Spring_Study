package com.Spring_Study.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Clazz {

  private Integer clazzId;
  private String clazzName;
  private  Integer teacherId;
  private Teacher teacher;
  private List<Student> students;


}
