package com.university.ead.controllers;

import com.university.ead.dtos.ErrorDto;
import com.university.ead.dtos.StudentResponseDto;
import com.university.ead.enums.ErrorCode;
import com.university.ead.exceptions.EadException;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<StudentResponseDto> onStudentFoundException(MethodArgumentNotValidException e) {
    var fieldErrors = e.getBindingResult()
            .getFieldErrors()
            .stream()
            .collect(Collectors.toMap(FieldError::getField, Objects.requireNonNull(DefaultMessageSourceResolvable::getDefaultMessage)));
    return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(StudentResponseDto.builder()
                    .errorsList(
                            fieldErrors.keySet()
                                    .stream()
                                    .map(o -> ErrorDto.builder()
                                            .code(ErrorCode.fromValue(o).getCode())
                                            .message(ErrorCode.fromValue(o).getMessage())
                                            .path(o)
                                            .build()
                                    ).collect(Collectors.toList())
                    ).build());
  }
}
