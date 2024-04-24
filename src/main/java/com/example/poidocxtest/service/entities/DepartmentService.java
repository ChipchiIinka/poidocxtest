package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.DepartmentDto;
import com.example.poidocxtest.entity.Department;
import com.example.poidocxtest.entity.enums.Position;
import com.example.poidocxtest.repository.DepartmentRepository;
import com.example.poidocxtest.repository.SpecialityRepository;
import com.example.poidocxtest.repository.TeacherRepository;
import com.example.poidocxtest.service.mapper.entities.DepartmentMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepo;
    private final DepartmentMapper departmentMapper;
    private final TeacherRepository teacherRepo;
    private final SpecialityRepository specialityRepo;

    public List<DepartmentDto> findAll(){
        return departmentMapper.toDtoList(departmentRepo.findAll());
    }

    public DepartmentDto findById(long id){
        return departmentMapper.toDto(departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("department not found")));
    }

    public void create(DepartmentDto dto){
        Department department = departmentMapper.toEntity(dto);

        department.setTeachers(dto.getTeachers().stream()
                .map(teacher -> teacherRepo.findBySurnameAndNameAndPatronymic(
                        teacher.split(" ")[0], teacher.split(" ")[1], teacher.split(" ")[2])
                        .orElseThrow(() -> new RuntimeException("teacher not found")))
                .toList());

        department.setDepartmentSuperintendent(
                teacherRepo.findByDepartmentAndPosition(department, Position.DEPARTMENT_SUPERINTENDENT)
                        .orElseThrow(() -> new RuntimeException("department superintendent not found")));
        department.setSpecialities(dto.getSpecialityTitles().stream()
                .map(speciality -> specialityRepo.findByTitle(speciality)
                        .orElseThrow(() -> new RuntimeException("speciality not found")))
                .toList());

        departmentRepo.save(department);
    }
}
