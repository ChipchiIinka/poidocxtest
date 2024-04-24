package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.GroupDto;
import com.example.poidocxtest.entity.Group;
import com.example.poidocxtest.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {
    public List<GroupDto> toDtoList (List<Group> groups){
        return groups.stream().map(this::toDto).toList();
    }

    public GroupDto toDto (Group group){
        return GroupDto.builder()
                .groupCode(group.getGroupCode())
                .specialityTitle(group.getSpeciality().getTitle())
                .studentNames(group.getStudents().stream()
                        .map(Student::makeInitials)
                        .toList())
                .build();
    }

    public Group toEntity (GroupDto dto){
        Group group = new Group();

        group.setGroupCode(dto.getGroupCode());

        return group;
    }
}
