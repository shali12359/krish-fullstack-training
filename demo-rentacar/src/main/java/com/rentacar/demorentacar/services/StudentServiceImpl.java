package com.rentacar.demorentacar.services;

import com.rentacar.demorentacar.models.Student;
import com.rentacar.demorentacar.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    // SAVE STUDENT
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // GET A SINGLE STUDENT
    public Student fetchStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }
}
