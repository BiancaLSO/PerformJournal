package com.ensemble.pj.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class User extends BaseDto {

  @Getter @Setter
  private String firstName;

  @Getter @Setter
  private String lastName;

  @Getter @Setter
  private String username;

  @Getter @Setter
  private String password;

  @Getter @Setter
  private boolean active;

  @Getter @Setter
  private List<Role> roles;

}
