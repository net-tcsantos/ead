package com.university.ead.dtos;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto implements Serializable {

  @NotNull
  @Size(min = 3, max = 30)
  private String firstName;
  @NotNull
  @Size(min = 3, max = 30)
  private String lastName;
  @NotNull
  @Size(min = 3, max = 50)
  @Email(message = "Email is invalid!")
  private String email;
  @NotNull
  @Size(min = 3, max = 100)
  private String password;
  @NotNull
  @Size(min = 14, max = 14)
  private String cpf;
  @NotNull
  @Size(min = 10, max = 10)
  private String dob;
}
