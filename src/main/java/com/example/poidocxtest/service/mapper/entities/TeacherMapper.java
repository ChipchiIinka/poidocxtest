package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.TeacherDto;
import com.example.poidocxtest.entity.Subjects;
import com.example.poidocxtest.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherMapper {
    public List<TeacherDto> toDtoList (List<Teacher> teachers){
        return teachers.stream().map(this::toDto).toList();
    }

    public TeacherDto toDto (Teacher teacher){
        return TeacherDto.builder()
                .surname(teacher.getSurname())
                .name(teacher.getName())
                .patronymic(teacher.getPatronymic())
                .position(teacher.getPosition().name())
                .departmentTitle(teacher.getDepartment().getTitle())
                .subjectsTitle(teacher.getSubjects().stream()
                        .map(Subjects::getTitle)
                        .collect(Collectors.toSet()))
                .facultyTitle(teacher.getFaculty().getTitle())
                .build();
    }

    public Teacher toEntity (TeacherDto dto){
        Teacher teacher = new Teacher();

        teacher.setSurname(dto.getSurname());
        teacher.setName(dto.getName());
        teacher.setPatronymic(dto.getPatronymic());

        return teacher;
    }
}
