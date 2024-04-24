package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.StudentDto;
import com.example.poidocxtest.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMapper {
    public List<StudentDto> toDtoList(List<Student> students){
        return students.stream().map(this::toDto).toList();
    }

    public StudentDto toDto (Student student){
        return StudentDto.builder()
                .surname(student.getSurname())
                .name(student.getName())
                .patronymic(student.getPatronymic())
                .recordBookNumber(student.getRecordBook().getNumber())
                .groupCode(student.getGroup().getGroupCode())
                .build();
    }

    public Student toEntity(StudentDto dto){
        Student student = new Student();

        student.setSurname(dto.getSurname());
        student.setName(dto.getName());
        student.setPatronymic(dto.getPatronymic());

        return student;
    }
}
