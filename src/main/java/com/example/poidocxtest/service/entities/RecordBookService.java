package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.RecordBookDto;
import com.example.poidocxtest.entity.RecordBook;
import com.example.poidocxtest.repository.RecordBookRepository;
import com.example.poidocxtest.repository.StudentRepository;
import com.example.poidocxtest.repository.SubjectsRepository;
import com.example.poidocxtest.service.mapper.entities.RecordBookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordBookService {
    private final RecordBookRepository recordBookRepo;
    private final RecordBookMapper recordBookMapper;
    private final StudentRepository studentRepository;
    private final SubjectsRepository subjectsRepository;

    public List<RecordBookDto> findAll(){
        return recordBookMapper.toDtoList(recordBookRepo.findAll());
    }

    public RecordBookDto findById(String id){
        return recordBookMapper.toDto(recordBookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("record book not found")));
    }

    public void create(RecordBookDto dto){
        RecordBook recordBook = new RecordBook();

        recordBook.setId(dto.getId());
        recordBook.setStudent(studentRepository.findBySurnameAndNameAndPatronymic(
                dto.getStudentName().split(" ")[0],
                dto.getStudentName().split(" ")[1],
                dto.getStudentName().split(" ")[2])
                .orElseThrow(()-> new RuntimeException("Student not found")));
        recordBook.setSubjects(dto.getSubjectsTitle().stream()
                .map(s -> subjectsRepository.findByTitle(s)
                        .orElseThrow(() -> new RuntimeException("subject not found")))
                .collect(Collectors.toSet()));

        recordBookRepo.save(recordBook);
    }
}
