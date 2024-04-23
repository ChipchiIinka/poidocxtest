package com.example.poidocxtest.dto.examinationsheet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ExaminationSheetDto {
    private String facultyShortName;
    private String deanName;
    private String facultyFullName;
    private String specialityCode;
    private String period;
    private String academicYear;
    private String academicDisciplineTitle;
    private String controlType;
    private String groupCode;
    private List<StudentSheetDto> students;
    private String departmentHeadName;
    private String secretaryName;
}
