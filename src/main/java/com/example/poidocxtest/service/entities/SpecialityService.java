package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.SpecialityDto;
import com.example.poidocxtest.entity.Speciality;
import com.example.poidocxtest.repository.DepartmentRepository;
import com.example.poidocxtest.repository.FacultyRepository;
import com.example.poidocxtest.repository.GroupRepository;
import com.example.poidocxtest.repository.SpecialityRepository;
import com.example.poidocxtest.service.mapper.entities.SpecialityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpecialityService {
    private final SpecialityRepository specialityRepo;
    private final SpecialityMapper specialityMapper;
    private final GroupRepository groupRepo;
    private final DepartmentRepository departmentRepo;
    private final FacultyRepository facultyRepo;

    public List<SpecialityDto> findAll(){
        return specialityMapper.toDtoList(specialityRepo.findAll());
    }

    public SpecialityDto findById(long id){
        return specialityMapper.toDto(specialityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("speciality not found")));
    }

    public void create(SpecialityDto dto){
        Speciality speciality = specialityMapper.toEntity(dto);

        speciality.setGroups(dto.getGroupCodes().stream()
                .map(code -> groupRepo.findByGroupCode(code)
                .orElseThrow(() -> new RuntimeException("group not found")))
                .collect(Collectors.toSet()));
        speciality.setDepartment(departmentRepo.findByTitle(dto.getDepartmentTitle())
                .orElseThrow(() -> new RuntimeException("department not found")));
        speciality.setFaculty(facultyRepo.findByTitle(dto.getFacultyTitle())
                .orElseThrow(() -> new RuntimeException("faculty not found")));

        specialityRepo.save(speciality);
    }
}
