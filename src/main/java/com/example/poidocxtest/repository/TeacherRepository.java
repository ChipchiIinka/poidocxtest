package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Long, Teacher> {
}
