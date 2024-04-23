package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Group;
import com.example.poidocxtest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Long, Student> {
    Optional<Student> findByGroup (Group group);
}
