package com.example.poidocxtest.repository;

import com.example.poidocxtest.entity.RecordBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordBookRepository extends JpaRepository<Long, RecordBook> {
}
