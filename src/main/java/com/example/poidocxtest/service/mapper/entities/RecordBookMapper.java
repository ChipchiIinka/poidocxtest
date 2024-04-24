package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.RecordBookDto;
import com.example.poidocxtest.entity.RecordBook;
import com.example.poidocxtest.entity.Subjects;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordBookMapper {
    public List<RecordBookDto> toDtoList (List<RecordBook> recordBooks){
        return recordBooks.stream().map(this::toDto).toList();
    }

    public RecordBookDto toDto (RecordBook recordBook){
        return RecordBookDto.builder()
                .number(recordBook.getNumber())
                .studentName(recordBook.getStudent().makeInitials())
                .subjectsTitle(recordBook.getSubjects().stream()
                        .map(Subjects::getTitle)
                        .toList())
                .build();
    }
}
