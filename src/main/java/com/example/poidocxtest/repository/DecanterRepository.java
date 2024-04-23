package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Decanter;
import com.example.poidocxtest.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DecanterRepository extends JpaRepository<Long, Decanter> {
    Optional<Decanter> findByFaculty (Faculty faculty);
}
