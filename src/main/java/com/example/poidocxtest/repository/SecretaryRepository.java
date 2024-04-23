package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretaryRepository extends JpaRepository<Long, Secretary> {
    Optional<Secretary> findById(Long id);
}
