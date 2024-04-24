package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.SpecialityDto;
import com.example.poidocxtest.entity.Group;
import com.example.poidocxtest.entity.Speciality;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialityMapper {
    public List<SpecialityDto> toDtoList(List<Speciality> specialities){
        return specialities.stream().map(this::toDto).toList();
    }

    public SpecialityDto toDto(Speciality speciality){
        return SpecialityDto.builder()
                .title(speciality.getTitle())
                .specialityCode(speciality.getSpecialityCode())
                .groupCodes(speciality.getGroups().stream()
                        .map(Group::getGroupCode)
                        .toList())
                .departmentTitle(speciality.getDepartment().getTitle())
                .facultyTitle(speciality.getFaculty().getTitle())
                .build();
    }

    public Speciality toEntity(SpecialityDto dto){
        Speciality speciality = new Speciality();

        speciality.setTitle(dto.getTitle());
        speciality.setSpecialityCode(dto.getSpecialityCode());

        return speciality;
    }
}
