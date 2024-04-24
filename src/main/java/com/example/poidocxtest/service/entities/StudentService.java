package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.StudentDto;
import com.example.poidocxtest.entity.Student;
import com.example.poidocxtest.repository.GroupRepository;
import com.example.poidocxtest.repository.RecordBookRepository;
import com.example.poidocxtest.repository.StudentRepository;
import com.example.poidocxtest.service.mapper.entities.StudentMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepo;
    private final StudentMapper studentMapper;
    private final GroupRepository groupRepo;
    private final RecordBookRepository recordBookRepo;

    public List<StudentDto> findAll(){
        return studentMapper.toDtoList(studentRepo.findAll());
    }

    public StudentDto findById(long id){
        return studentMapper.toDto(studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("student not found")));
    }

    public void create(StudentDto dto){
        Student student = studentMapper.toEntity(dto);

        student.setRecordBook(recordBookRepo.findByNumber(dto.getRecordBookNumber())
                .orElseThrow(()-> new RuntimeException("record book not found")));
        student.setGroup(groupRepo.findByGroupCode(dto.getGroupCode())
                .orElseThrow(()-> new RuntimeException("group not found")));

        studentRepo.save(student);
    }
}
