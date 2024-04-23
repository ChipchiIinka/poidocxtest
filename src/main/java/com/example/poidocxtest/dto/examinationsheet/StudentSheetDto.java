package com.example.poidocxtest.dto.examinationsheet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class StudentSheetDto {
    private String fullName;
    private String recordBookNumber;
    private String grade;
}
