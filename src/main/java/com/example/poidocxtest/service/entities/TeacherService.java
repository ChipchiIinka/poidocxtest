package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.TeacherDto;
import com.example.poidocxtest.entity.Teacher;
import com.example.poidocxtest.repository.DepartmentRepository;
import com.example.poidocxtest.repository.FacultyRepository;
import com.example.poidocxtest.repository.SubjectsRepository;
import com.example.poidocxtest.repository.TeacherRepository;
import com.example.poidocxtest.service.mapper.entities.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherMapper teacherMapper;
    private final TeacherRepository teacherRepo;
    private final DepartmentRepository departmentRepo;
    private final SubjectsRepository subjectsRepo;
    private final FacultyRepository facultyRepo;

    public List<TeacherDto> findAll (){
        return teacherMapper.toDtoList(teacherRepo.findAll());
    }

    public TeacherDto findById(long id){
        return teacherMapper.toDto(teacherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("teacher not found")));
    }

    public void create(TeacherDto dto){
        Teacher teacher = teacherMapper.toEntity(dto);

        teacher.setDepartment(departmentRepo.findByTitle(dto.getDepartmentTitle())
                .orElseThrow(() -> new RuntimeException("department not found")));
        teacher.setSubjects(dto.getSubjectsTitle().stream()
                .map(subject -> subjectsRepo.findByTitle(subject)
                        .orElseThrow(() -> new RuntimeException("teacher not found")))
                .collect(Collectors.toSet()));
        teacher.setFaculty(facultyRepo.findByTitle(dto.getFacultyTitle())
                .orElseThrow(() -> new RuntimeException("faculty not found")));

        teacherRepo.save(teacher);
    }
}
