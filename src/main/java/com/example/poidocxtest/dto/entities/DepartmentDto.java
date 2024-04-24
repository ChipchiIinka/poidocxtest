package com.example.poidocxtest.dto.entities;

import com.example.poidocxtest.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class DepartmentDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("teachers")
    private List<String> teachers;

    @JsonProperty("department_superintendent")
    private String departmentSuperintendentName;

    @OneToMany
    @JoinColumn(name = "specialities")
    private List<String> specialityTitles;
}
