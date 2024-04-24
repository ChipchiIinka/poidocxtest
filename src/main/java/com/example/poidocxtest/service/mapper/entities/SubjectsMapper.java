package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.SubjectsDto;
import com.example.poidocxtest.entity.Subjects;
import com.example.poidocxtest.entity.enums.ControlType;
import com.example.poidocxtest.entity.enums.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsMapper {
    public List<SubjectsDto> toDtoList(List<Subjects> subjects){
        return subjects.stream().map(this::toDto).toList();
    }

    public SubjectsDto toDto(Subjects subjects){
        return SubjectsDto.builder()
                .title(subjects.getTitle())
                .hours(subjects.getHours())
                .controlType(subjects.getControlType().getTitle())
                .semester(subjects.getSemester())
                .teacherName(subjects.getTeacher().makeFullName())
                .recordBookNumber(subjects.getRecordBook().getNumber())
                .grade(subjects.getGrade().getName())
                .build();
    }

    public Subjects toEntity(SubjectsDto dto){
        Subjects subjects = new Subjects();

        subjects.setTitle(dto.getTitle());
        subjects.setHours(dto.getHours());

        if (dto.getControlType().equals("Экзамен")) {
            subjects.setControlType(ControlType.TEST);
        } else {
            subjects.setControlType(ControlType.DIFFERENTIATED_TEST);
        }

        subjects.setSemester(dto.getSemester());

        switch (dto.getGrade()) {
            case "Отлично" -> subjects.setGrade(Grade.GREAT);
            case "Хорошо" -> subjects.setGrade(Grade.GOOD);
            case "Удовл." -> subjects.setGrade(Grade.SATISFACTORILY);
            case "Неудовл." -> subjects.setGrade(Grade.UNSATISFACTORILY);
            case "Зачет" -> subjects.setGrade(Grade.PASSED);
            case "Незачет" -> subjects.setGrade(Grade.FAIL);
            default -> subjects.setGrade(Grade.UNAUTHORISED);
        }

        return subjects;
    }
}
