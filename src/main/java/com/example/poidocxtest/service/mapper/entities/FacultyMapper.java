package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.FacultyDto;
import com.example.poidocxtest.entity.Faculty;
import com.example.poidocxtest.entity.Speciality;
import com.example.poidocxtest.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyMapper {
    public List<FacultyDto> toDtoList (List<Faculty> faculties){
        return faculties.stream().map(this::toDto).toList();
    }

    public FacultyDto toDto (Faculty faculty){
        return FacultyDto.builder()
                .title(faculty.getTitle())
                .shortTitle(faculty.getShortTitle())
                .decanterName(faculty.getDecanter().makeInitials())
                .specialitiesTitles(faculty.getSpecialities().stream()
                        .map(Speciality::getTitle)
                        .collect(Collectors.toSet()))
                .teachersName(faculty.getTeachers().stream()
                        .map(Teacher::makeInitials)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Faculty toEntity (FacultyDto dto){
        Faculty faculty = new Faculty();

        faculty.setTitle(dto.getTitle());
        faculty.setShortTitle(dto.getShortTitle());

        return faculty;
    }
}
