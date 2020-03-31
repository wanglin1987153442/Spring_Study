package com.Spring_Study.mybatis.domain;

import com.Spring_Study.mybatis.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wl
 * @ClassNameMatterDto
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MatterDto {
    private String teacherName;
    private  String clazzName;
    private Student student;

}
