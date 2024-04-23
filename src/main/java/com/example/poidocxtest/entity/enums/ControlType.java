package com.example.poidocxtest.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ControlType {
    DIFFERENTIATED_TEST("Дифференцированый Зачет"),
    TEST("Зачет");

    private final String title;
}
