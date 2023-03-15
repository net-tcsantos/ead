package com.university.ead.controllers;

import com.university.ead.dtos.ErrorDto;
import com.university.ead.dtos.StudentResponseDto;
import com.university.ead.exceptions.EadException;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

  @ExceptionHandler(EadException.class)
  public ResponseEntity<StudentResponseDto> onStudentFoundException(EadException e) {
    return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(StudentResponseDto.builder()
                    .errorsList(
                            Collections.singletonList(
                                    ErrorDto.builder()
                                            .code(e.getCode())
                                            .message(e.getMessage())
                                            .build()
                            )
                    ).build());
  }
}
