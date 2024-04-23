package com.example.poidocxtest.service.mapper.util;

import com.example.poidocxtest.dto.examinationsheet.ExaminationSheetDto;
import com.example.poidocxtest.dto.examinationsheet.StudentSheetDto;
import com.example.poidocxtest.entity.*;
import com.example.poidocxtest.entity.enums.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UtilMapper {
    private long gradeCounter(List<Grade> grades, Grade grade){
        return grades.stream().map(g -> Objects.equals(g, grade)).count();
    }

    private double gradeCounterPercent (List<Grade> grades, Grade grade){
        return (double) (gradeCounter(grades, grade))/grades.size()*100;
    }

    private String makeInitials (Human human){
        return  human.getSurname() + " " + human.getName().charAt(0) + ". " + human.getPatronymic().charAt(0) + ".";
    }

    private String makeStudyYears (){
        if (Month.JANUARY.getValue() <= LocalDate.now().getMonth().getValue() &&
                LocalDate.now().getMonth().getValue() < Month.SEPTEMBER.getValue()){
            return String.valueOf(LocalDate.now().getYear()-1) + String.valueOf(LocalDate.now().getYear());
        }
        return String.valueOf(LocalDate.now().getYear()) + String.valueOf(LocalDate.now().getYear()+1);
    }

    public ExaminationSheetDto toDataDto (Decanter decanter, Faculty faculty,
                                          Speciality speciality, Subjects subject,
                                          Group group, Department department, Secretary secretary){
        return ExaminationSheetDto.builder()
                .facultyShortName(faculty.getShortTitle())
                .deanName(makeInitials(decanter))
                .facultyFullName(faculty.getTitle())
                .specialityCode(speciality.getSpecialityCode())
                .period(LocalDate.now().getMonth().name())
                .academicYear(makeStudyYears())
                .academicDisciplineTitle(subject.getTitle())
                .controlType(subject.getControlType().getTitle())
                .groupCode(group.getGroupCode())
                .students(toStudentDtoList(group.getStudents().stream().toList(), subject))
                .departmentHeadName(makeInitials(department.getDepartmentSuperintendent()))
                .secretaryName(makeInitials(secretary))
                .build();
    }

    private List<StudentSheetDto> toStudentDtoList (List<Student> students, Subjects subject){
        List<StudentSheetDto> studentSheetDto = new ArrayList<>();
        for (Student student : students) {
            studentSheetDto.add(StudentSheetDto.builder()
                    .fullName(student.getSurname() + " " + student.getName() + " " + student.getPatronymic())
                    .recordBookNumber(student.getRecordBook().getId().toString())
                    .grade(subject.getGrade().getName())
                    .build());
        }
        return studentSheetDto;
    }
}
