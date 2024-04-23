package com.example.assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment3.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
