package com.university.ead.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.university.ead.models.Student;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponseDto implements Serializable {

  private Student student;
  @JsonProperty("students")
  private List<Student> studentList;
  @JsonProperty("errors")
  private List<ErrorDto> errorsList;
}
