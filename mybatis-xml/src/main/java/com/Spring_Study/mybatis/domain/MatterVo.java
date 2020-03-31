package com.Spring_Study.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wl
 * @ClassNameMatterVo
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MatterVo {
    private String teacherName;
    private  String clazzName;
    private String studentName;
    private  String hometown;
    private  String birthday;
}
