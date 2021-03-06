package com.ensemble.pj.dto;

public enum Role {

  USER("USER"),

  ADMIN("ADMIN");


  private String value;

  Role(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
