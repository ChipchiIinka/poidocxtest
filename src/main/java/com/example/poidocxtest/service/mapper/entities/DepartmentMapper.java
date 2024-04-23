package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.DepartmentDto;
import com.example.poidocxtest.entity.Department;
import com.example.poidocxtest.entity.Speciality;
import com.example.poidocxtest.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentMapper {
    public List<DepartmentDto> toDtoList (List<Department> departments){
        return departments.stream().map(this::toDto).toList();
    }

    public DepartmentDto toDto (Department department){
        return DepartmentDto.builder()
                .title(department.getTitle())
                .teachers(department.getTeachers().stream()
                        .map(Teacher::makeInitials)
                        .toList())
                .departmentSuperintendentName(department.getDepartmentSuperintendent().makeInitials())
                .specialityTitles(department.getSpecialities().stream()
                        .map(Speciality::getTitle)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Department toEntity (DepartmentDto dto){
        Department department = new Department();

        department.setTitle(dto.getTitle());

        return department;
    }
}
