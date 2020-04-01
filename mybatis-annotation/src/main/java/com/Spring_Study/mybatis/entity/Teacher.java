package com.Spring_Study.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 林小派
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

  private Integer teacherId;
  private String teacherName;
  private Integer clazzId;
  private Clazz clazz;

}
