package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Department;
import com.example.poidocxtest.entity.Teacher;
import com.example.poidocxtest.entity.enums.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findBySurnameAndNameAndPatronymic (String surname, String name, String patronymic);
    Optional<Teacher> findByDepartmentAndPosition (Department department, Position position);
}
