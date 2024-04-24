package com.example.poidocxtest.controller;

import com.example.poidocxtest.dto.entities.*;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class UtilController {
    private final UtilService service;
    private final DecanterService decanterService;
    private final DepartmentService departmentService;
    private final FacultyService facultyService;
    private final GroupService groupService;
    private final RecordBookService recordBookService;
    private final SecretaryService secretaryService;
    private final SpecialityService specialityService;
    private final StudentService studentService;
    private final SubjectsService subjectsService;
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ByteArrayResource> getAllData (String groupCode, long subjectId, long secretaryId) throws Exception {
        return service.makeExaminationSheet(groupCode, subjectId, secretaryId);
    }


//
//    @PostMapping
//    public void createAllInOne(@RequestBody @Valid DecanterDto decD, @RequestBody @Valid DepartmentDto depD,
//                               @RequestBody @Valid FacultyDto facD, @RequestBody @Valid GroupDto groD,
//                               @RequestBody @Valid RecordBookDto rBD, @RequestBody @Valid SecretaryDto secD,
//                               @RequestBody @Valid SpecialityDto speD, @RequestBody @Valid StudentDto stuD,
//                               @RequestBody @Valid SubjectsDto subD, @RequestBody @Valid TeacherDto teaD){
//        decanterService.create(decD);
//        departmentService.create(depD);
//        facultyService.create(facD);
//        groupService.create(groD);
//        recordBookService.create(rBD);
//        secretaryService.create(secD);
//        specialityService.create(speD);
//        studentService.create(stuD);
//        subjectsService.create(subD);
//        teacherService.create(teaD);
//    }
}
