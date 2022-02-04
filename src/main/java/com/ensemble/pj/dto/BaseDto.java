package com.ensemble.pj.dto;

import lombok.Getter;
import lombok.Setter;

public class BaseDto {

  @Getter @Setter
  private String id;

  @Getter @Setter
  private String createdAt;

  @Getter @Setter
  private String modifiedAt;
}
