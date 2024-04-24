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
public class FacultyDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("short_title")
    private String shortTitle;

    @JsonProperty("decanter")
    private String decanterName;

    @JsonProperty("specialities")
    private List<String> specialitiesTitles;

    @JsonProperty("teachers")
    private List<String> teachersName;
}
