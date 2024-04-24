package com.example.poidocxtest.dto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
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
    private List<String> groupCodes;

    @JsonProperty("department")
    private String departmentTitle;

    @JsonProperty("faculty")
    private String facultyTitle;
}
