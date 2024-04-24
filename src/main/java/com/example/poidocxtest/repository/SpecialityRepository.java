package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Group;
import com.example.poidocxtest.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    Optional<Speciality> findByGroupsContaining (Group group);
    Optional<Speciality> findByTitle (String title);
}
