package com.university.ead.dtos;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto implements Serializable {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String cpf;
  private String dob;
}
