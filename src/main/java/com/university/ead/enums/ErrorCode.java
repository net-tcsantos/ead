package com.university.ead.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.university.ead.exceptions.EadException;

public enum ErrorCode {
  STUDENT_NOT_FOUND(100, "Student does not exist."),
  STUDENT_FOUND(101, "Student already exists."),
  INVALID_ENUM(102, "Enum value provided has a value that do not match."),
  EMAIL(103, "Field has failed validation.");
  private final int code;
  private final String message;

  ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public static ErrorCode fromValue(String v) {
    for (ErrorCode c : ErrorCode.values()) {
      if (c.name().equalsIgnoreCase(v)) {
        return c;
      }
    }
    throw new EadException(INVALID_ENUM.getMessage(), INVALID_ENUM.getCode());
  }

  @JsonValue
  public int getCode() {
    return code;
  }

  @JsonValue
  public String getMessage() {
    return message;
  }
}
