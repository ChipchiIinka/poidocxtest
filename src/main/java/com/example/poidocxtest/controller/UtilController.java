package com.example.poidocxtest.controller;

import com.example.poidocxtest.service.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UtilController {
    private final UtilService service;

    @GetMapping
    public void getAllData (String groupCode, long subjectId, long secretaryId) throws Exception {
        service.makeExaminationSheet(groupCode, subjectId, secretaryId);
    }
}
