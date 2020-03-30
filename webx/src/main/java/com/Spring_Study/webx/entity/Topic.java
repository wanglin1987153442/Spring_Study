package com.Spring_Study.webx.entity;

import lombok.Data;

@Data
public class Topic {

  private Integer id;
  private String topicName;
  private String topicIcon;
  private Integer pins;
  private Integer follows;

}
