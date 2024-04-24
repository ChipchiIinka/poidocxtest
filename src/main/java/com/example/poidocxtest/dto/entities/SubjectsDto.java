package com.example.poidocxtest.dto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Schema(description = "Make subject")
public class SubjectsDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("hours")
    private Integer hours;

    @JsonProperty("control_type")
    private String controlType;

    @JsonProperty("semester")
    private int semester;

    @JsonProperty("teacher")
    private String teacherName;

    @JsonProperty("record_book")
    private String recordBookNumber;

    @JsonProperty("grade")
    private String grade;
}
