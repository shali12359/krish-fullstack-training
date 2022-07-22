package com.rentacar.demorentacar.repositories;

import com.rentacar.demorentacar.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
