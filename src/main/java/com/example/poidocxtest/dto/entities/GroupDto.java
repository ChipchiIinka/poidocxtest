package com.example.poidocxtest.dto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class GroupDto {
    @JsonProperty("group_code")
    private String groupCode;

    @JsonProperty("speciality")
    private String specialityTitle;

    @JsonProperty("students")
    private Set<String> studentNames;
}
