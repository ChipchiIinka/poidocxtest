package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.FacultyDto;
import com.example.poidocxtest.entity.Faculty;
import com.example.poidocxtest.repository.DecanterRepository;
import com.example.poidocxtest.repository.FacultyRepository;
import com.example.poidocxtest.repository.SpecialityRepository;
import com.example.poidocxtest.repository.TeacherRepository;
import com.example.poidocxtest.service.mapper.entities.FacultyMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepo;
    private final FacultyMapper facultyMapper;
    private final DecanterRepository decanterRepo;
    private final SpecialityRepository specialityRepo;
    private final TeacherRepository teacherRepo;

    public List<FacultyDto> findAll(){
        return facultyMapper.toDtoList(facultyRepo.findAll());
    }

    public FacultyDto findById(long id){
        return facultyMapper.toDto(facultyRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("faculty not found")));
    }

    public void create(FacultyDto dto){
        Faculty faculty = facultyMapper.toEntity(dto);

        faculty.setDecanter(decanterRepo.findBySurnameAndNameAndPatronymic(
                        dto.getDecanterName().split(" ")[0],
                        dto.getDecanterName().split(" ")[1],
                        dto.getDecanterName().split(" ")[2])
                .orElseThrow(() -> new RuntimeException("decanter not found")));
        faculty.setSpecialities(dto.getSpecialitiesTitles().stream()
                .map(s -> specialityRepo.findByTitle(s)
                        .orElseThrow(() -> new RuntimeException("speciality not found")))
                .toList());
        faculty.setTeachers(dto.getTeachersName().stream()
                .map(teacher -> teacherRepo.findBySurnameAndNameAndPatronymic(
                                teacher.split(" ")[0], teacher.split(" ")[1], teacher.split(" ")[2])
                        .orElseThrow(() -> new RuntimeException("teacher not found")))
                .toList());

        facultyRepo.save(faculty);
    }
}
