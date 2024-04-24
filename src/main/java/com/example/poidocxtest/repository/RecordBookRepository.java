package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.RecordBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordBookRepository extends JpaRepository<RecordBook, Long> {
    Optional<RecordBook> findByNumber (String number);
}
