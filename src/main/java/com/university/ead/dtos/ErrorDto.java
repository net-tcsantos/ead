package com.university.ead.dtos;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto implements Serializable {

  private int code;
  private String message;
}
