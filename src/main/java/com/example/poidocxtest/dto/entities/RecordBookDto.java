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
public class RecordBookDto {
    @JsonProperty("number")
    private String number;

    @JsonProperty("student")
    private String studentName;

    @JsonProperty("subjects")
    private List<String> subjectsTitle;
}
