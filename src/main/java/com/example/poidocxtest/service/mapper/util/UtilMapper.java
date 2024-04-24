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

    public ExaminationSheetDto toDataDto (Decanter decanter, Faculty faculty,
                                          Speciality speciality, Subjects subject,
                                          Group group, Department department, Secretary secretary){
        return ExaminationSheetDto.builder()
                .facultyShortName(faculty.getShortTitle())
                .deanName(decanter.makeInitials())
                .facultyFullName(faculty.getTitle())
                .specialityCode(speciality.getSpecialityCode())
                .period(makeCorrectPeriod())
                .academicYear(makeStudyYears())
                .academicDisciplineTitle(subject.getTitle())
                .controlType(subject.getControlType().getTitle())
                .groupCode(group.getGroupCode())
                .students(toStudentDtoList(group.getStudents().stream().toList(), subject))
                .departmentHeadName(department.getDepartmentSuperintendent().makeInitials())
                .secretaryName(secretary.makeInitials())
                .build();
    }

    private List<StudentSheetDto> toStudentDtoList (List<Student> students, Subjects subject){
        List<StudentSheetDto> studentSheetDto = new ArrayList<>();
        for (Student student : students) {
            studentSheetDto.add(StudentSheetDto.builder()
                    .fullName(student.getSurname() + " " + student.getName() + " " + student.getPatronymic())
                    .recordBookNumber(student.getRecordBook().getNumber())
                    .grade(subject.getGrade().getName())
                    .build());
        }
        return studentSheetDto;
    }

    //Подсчет всех оценок
    private long gradeCounter(List<Grade> grades, Grade grade){
        return grades.stream().map(g -> Objects.equals(g, grade)).count();
    }

    //Подсчет процента оценок
    private double gradeCounterPercent (List<Grade> grades, Grade grade){
        return (double) (gradeCounter(grades, grade))/grades.size()*100;
    }

    //Создание корректного названия периода
    private String makeCorrectPeriod(){
        switch (LocalDate.now().getMonth()){
            case JANUARY -> {
                return "январский";
            }
            case FEBRUARY -> {
                return "февральский";
            }
            case MARCH -> {
                return "мартский";
            }
            case APRIL -> {
                return "апрельский";
            }
            case MAY -> {
                return "майский";
            }
            case JUNE -> {
                return "июньский";
            }
            case SEPTEMBER -> {
                return "сентябрьский";
            }
            case OCTOBER -> {
                return "октябрьский";
            }
            case NOVEMBER -> {
                return "ноябрьский";
            }
            default -> {
                return "декабрьский";
            }
        }
    }

    //создание правильного отображения учебного года
    private String makeStudyYears (){
        if (Month.JANUARY.getValue() <= LocalDate.now().getMonth().getValue() &&
                LocalDate.now().getMonth().getValue() < Month.SEPTEMBER.getValue()){
            return (LocalDate.now().getYear()-1) + " - " + LocalDate.now().getYear();
        }
        return (LocalDate.now().getYear()) + " - " + (LocalDate.now().getYear() + 1);
    }
}
