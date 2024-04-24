package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.SubjectsDto;
import com.example.poidocxtest.entity.Subjects;
import com.example.poidocxtest.repository.RecordBookRepository;
import com.example.poidocxtest.repository.SubjectsRepository;
import com.example.poidocxtest.repository.TeacherRepository;
import com.example.poidocxtest.service.mapper.entities.SubjectsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectsService {
    private final SubjectsRepository subjectsRepo;
    private final SubjectsMapper subjectsMapper;
    private final TeacherRepository teacherRepo;
    private final RecordBookRepository recordBookRepo;

    public List<SubjectsDto> findAll(){
        return subjectsMapper.toDtoList(subjectsRepo.findAll());
    }

    public SubjectsDto findById(long id){
        return subjectsMapper.toDto(subjectsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("subject not found")));
    }

    public void create(SubjectsDto dto){
        Subjects subject = subjectsMapper.toEntity(dto);

        subject.setTeacher(teacherRepo.findBySurnameAndNameAndPatronymic(
                dto.getTeacherName().split(" ")[0],
                dto.getTeacherName().split(" ")[1],
                dto.getTeacherName().split(" ")[2])
                .orElseThrow(() -> new RuntimeException("Teacher not found")));
        subject.setRecordBook(recordBookRepo.findById(dto.getRecordBookId())
                .orElseThrow(() -> new RuntimeException("Record Book not found")));

        subjectsRepo.save(subject);
    }
}

