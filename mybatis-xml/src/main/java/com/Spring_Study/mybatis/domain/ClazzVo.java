package com.Spring_Study.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author wl
 * @ClassNameClazzVo
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClazzVo {
    private Integer clazzId;
    private  String clazzName;
    private  Integer studentId;
    private  String studentName;
    private  String hometown;
    private LocalDate birthday;
}
