package com.university.ead.controllers;

import com.university.ead.dtos.StudentRequestDto;
import com.university.ead.dtos.StudentResponseDto;
import com.university.ead.services.StudentService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudentController {

  private final StudentService service;

  @PostMapping("/students")
  public ResponseEntity<StudentResponseDto> saveStudent(@RequestBody StudentRequestDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.saveStudent(dto));
  }

  @GetMapping("/students/{id}")
  public ResponseEntity<StudentResponseDto> saveStudent(@PathVariable UUID id) {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.findOneStudent(id));
  }

  @GetMapping("/students")
  public ResponseEntity<StudentResponseDto> saveStudent() {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.findAllStudents());
  }

  @PutMapping("/students/{id}")
  public ResponseEntity<StudentResponseDto> saveStudent(@RequestBody StudentRequestDto dto, @PathVariable UUID id) {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.updateStudent(dto, id));
  }

  @DeleteMapping("/students/{id}")
  public ResponseEntity<?> deleteStudent(@PathVariable UUID id) {
    service.deleteOneStudent(id);
    return ResponseEntity.noContent().build();
  }
}
