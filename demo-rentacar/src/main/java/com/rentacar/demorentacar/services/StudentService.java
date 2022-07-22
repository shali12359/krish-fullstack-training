package com.rentacar.demorentacar.services;

import com.rentacar.demorentacar.models.Student;

public interface StudentService {
    Student save(Student student);

    Student fetchStudentById(int id);
}
