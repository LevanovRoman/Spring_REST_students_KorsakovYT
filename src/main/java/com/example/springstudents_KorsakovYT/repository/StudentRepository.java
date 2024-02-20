package com.example.springstudents_KorsakovYT.repository;

import com.example.springstudents_KorsakovYT.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    void deleteByEmail(String email);

    Student findStudentByEmail(String email);
}
