package com.university.ead.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EadException extends RuntimeException {

  private String message;
  private int code;

  public EadException(String message, int code) {
    this.message = message;
    this.code = code;
  }
}
