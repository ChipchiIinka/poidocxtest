package com.example.poidocxtest.controller;

import com.example.poidocxtest.dto.entities.*;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public void getAllData (String groupCode, long subjectId, long secretaryId) throws Exception {
        service.makeExaminationSheet(groupCode, subjectId, secretaryId);
    }

//
//    @PostMapping
//    public void createAllInOne(@RequestBody DecanterDto decD, @RequestBody DepartmentDto depD,
//                               @RequestBody FacultyDto facD, @RequestBody GroupDto groD,
//                               @RequestBody RecordBookDto rBD, @RequestBody SecretaryDto secD,
//                               @RequestBody SpecialityDto speD, @RequestBody StudentDto stuD,
//                               @RequestBody SubjectsDto subD, @RequestBody TeacherDto teaD){
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
