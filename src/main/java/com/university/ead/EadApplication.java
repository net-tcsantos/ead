package com.university.ead;

import com.university.ead.models.Student;
import com.university.ead.repositories.StudentRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EadApplication {
  private final StudentRepository repository;

  public EadApplication(StudentRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(EadApplication.class, args);
  }


  @Bean
  CommandLineRunner run() {
    return args -> {
      var student1 = Student.builder()
              .firstName("Matheus")
              .lastName("Lorenco")
              .email("matheus@matheus.com")
              .password("123456")
              .cpf("111.111.111-11")
              .dob("10/10/2010")
              .build();
      var student2 = Student.builder()
              .firstName("Thiago")
              .lastName("Santos")
              .email("thiago@thiago.com")
              .password("123456")
              .cpf("111.111.111-11")
              .dob("10/10/2010")
              .build();

      repository.saveAll(List.of(student1, student2));
    };
  }
}
