package com.example.poidocxtest.dto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class SpecialityDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("speciality_code")
    private String specialityCode;

    @JsonProperty("groups")
    private Set<String> groupNames;

    @JsonProperty("department")
    private String departmentName;

    @JsonProperty("faculty")
    private String facultyName;

    @JsonProperty("students")
    private Set<String> students;
}
