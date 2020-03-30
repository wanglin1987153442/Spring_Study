package com.Spring_Study.webx.entity;

import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

  private String skuId;
  private String type;
  private String description;
  private String title;
  private String url;
  private String cover;
  private long bookSize;
  private String name;
  private String price;



}
