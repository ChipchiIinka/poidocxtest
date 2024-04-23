package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Faculty;
import com.example.poidocxtest.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findByTitle (String title);
    Optional<Faculty> findBySpeciality (Speciality speciality);
}
