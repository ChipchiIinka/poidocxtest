package com.example.poidocxtest.dto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Schema(description = "Make teacher")
public class TeacherDto {
    @JsonProperty("surname")
    private String surname;

    @JsonProperty("name")
    private String name;

    @JsonProperty("patronymic")
    private String patronymic;

    @JsonProperty("position")
    private String position;

    @JsonProperty("department")
    private String departmentTitle;

    @JsonProperty("subjects")
    private List<String> subjectsTitle;

    @JsonProperty("faculty")
    private String facultyTitle;
}
