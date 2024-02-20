package com.example.springstudents_KorsakovYT.repository;


import com.example.springstudents_KorsakovYT.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDAO {
    private final List<Student> STUDENTS = new ArrayList<>();
//        return List.of(
//                Student.builder().firstname("qОлег").email("wer@df.com").age(21).build(),
//                Student.builder().firstname("Василий").email("vas@df.com").age(33).build(),
//                Student.builder().firstname("Анна").email("ann@df.com").age(38).build()
//
//        );

    public List<Student> findAllStudent(){
        return STUDENTS;
    }

    public Student saveStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if (studentIndex > -1){
            STUDENTS.set(studentIndex, student);
            return student;
        }
        return null;
    }

    public void deleteStudent(String email) {
        var student = findByEmail(email);
        if (student != null){
            STUDENTS.remove(student);
        }
    }
}
