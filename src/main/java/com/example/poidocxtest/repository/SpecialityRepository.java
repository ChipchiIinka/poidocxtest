package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Group;
import com.example.poidocxtest.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialityRepository extends JpaRepository<Long, Speciality> {
    Optional<Speciality> findByGroup (Group group);
}
