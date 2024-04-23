package com.example.poidocxtest.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Grade {
    GREAT("Отлично"),
    GOOD("Хорошо"),
    SATISFACTORILY("Удовл."),
    UNSATISFACTORILY("Неудовл."),
    UNAUTHORISED("Недопущен"),
    PASSED("Зачет"),
    FAIL("Незачет");
    private final String name;
}
