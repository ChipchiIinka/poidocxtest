package com.example.poidocxtest.dto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class RecordBookDto {
    @JsonProperty("student")
    private String studentName;

    @JsonProperty("subjects")
    private Set<String> subjectsName;
}
