package com.university.ead.repositories;

import com.university.ead.models.Student;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, UUID> {
  Optional<Student> findByEmail(String email);
}
