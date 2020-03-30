package com.Spring_Study.webx.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wl
 * @ClassNameAuthors
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authors {
    private String avatar_url;
    private String name;
    private  String gender;
    private  String type;
    private  String id;
}
