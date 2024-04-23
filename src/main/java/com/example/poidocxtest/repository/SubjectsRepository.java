package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectsRepository extends JpaRepository<Long, Subjects> {
    Optional<Subjects> findById(long subjectId);
}
