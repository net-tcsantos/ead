package com.university.ead.services;

import com.university.ead.dtos.StudentRequestDto;
import com.university.ead.dtos.StudentResponseDto;
import com.university.ead.enums.ErrorCode;
import com.university.ead.exceptions.EadException;
import com.university.ead.models.Student;
import com.university.ead.repositories.StudentRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

  private final StudentRepository repository;

  public StudentResponseDto saveStudent(StudentRequestDto dto) {
    if (repository.findByEmail(dto.getEmail()).isPresent()) {
      throw new EadException(ErrorCode.STUDENT_FOUND.getMessage(), ErrorCode.STUDENT_FOUND.getCode());
    }
    var student = new Student();
    BeanUtils.copyProperties(dto, student);
    var savedStudent = repository.save(student);
    return StudentResponseDto
            .builder()
            .student(savedStudent)
            .build();
  }

  public StudentResponseDto findOneStudent(UUID id) {
    Optional<Student> studentOptional = repository.findById(id);
    if (studentOptional.isEmpty()) {
      throw new EadException(ErrorCode.STUDENT_NOT_FOUND.getMessage(), ErrorCode.STUDENT_NOT_FOUND.getCode());
    }
    return StudentResponseDto
            .builder()
            .student(studentOptional.get())
            .build();
  }

  public StudentResponseDto findAllStudents() {
    List<Student> studentList = repository.findAll();
    if (studentList.isEmpty()) {
      throw new EadException(ErrorCode.STUDENT_NOT_FOUND.getMessage(), ErrorCode.STUDENT_NOT_FOUND.getCode());
    }
    return StudentResponseDto
            .builder()
            .studentList(studentList)
            .build();
  }

  public StudentResponseDto updateStudent(StudentRequestDto dto, UUID id) {
    Optional<Student> studentOptional = repository.findById(id);
    if (studentOptional.isEmpty()) {
      throw new EadException(ErrorCode.STUDENT_NOT_FOUND.getMessage(), ErrorCode.STUDENT_NOT_FOUND.getCode());
    }
    studentOptional.get().setPassword(dto.getPassword());
    studentOptional.get().setDob(dto.getDob());
    studentOptional.get().setCpf(dto.getCpf());
    var savedStudent = repository.save(studentOptional.get());
    return StudentResponseDto
            .builder()
            .student(savedStudent)
            .build();
  }

  public void deleteOneStudent(UUID id) {
    Optional<Student> studentOptional = repository.findById(id);
    if (studentOptional.isEmpty()) {
      throw new EadException(ErrorCode.STUDENT_NOT_FOUND.getMessage(), ErrorCode.STUDENT_NOT_FOUND.getCode());
    }
    repository.delete(studentOptional.get());
  }
}
