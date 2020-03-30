package com.Spring_Study.webx.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bili {
  private long num;
  private String title;
  private String img;
  private String play;
  private String view;
  private String author;
  private long score;


}
