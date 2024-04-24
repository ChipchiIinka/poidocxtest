package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.GroupDto;
import com.example.poidocxtest.entity.Group;
import com.example.poidocxtest.repository.GroupRepository;
import com.example.poidocxtest.repository.SpecialityRepository;
import com.example.poidocxtest.repository.StudentRepository;
import com.example.poidocxtest.service.mapper.entities.GroupMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepo;
    private final GroupMapper groupMapper;
    private final SpecialityRepository specialityRepo;
    private final StudentRepository studentRepo;

    public List<GroupDto> findAll (){
        return groupMapper.toDtoList(groupRepo.findAll());
    }

    public GroupDto findById(long id){
        return groupMapper.toDto(groupRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found")));
    }

    public void create (GroupDto dto) {
        Group group = groupMapper.toEntity(dto);

        group.setSpeciality(specialityRepo.findByTitle(dto.getSpecialityTitle())
                .orElseThrow(()-> new RuntimeException("speciality not found")));
        group.setStudents(dto.getStudentNames().stream().map(s -> studentRepo.findBySurnameAndNameAndPatronymic(
                s.split(" ")[0], s.split(" ")[1], s.split(" ")[2])
                .orElseThrow(() -> new RuntimeException("student not found")))
                .toList());
        groupRepo.save(group);
    }
}
