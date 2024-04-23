package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Department;
import com.example.poidocxtest.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Long, Department> {
    Optional<Department> findBySpeciality (Speciality speciality);
}
