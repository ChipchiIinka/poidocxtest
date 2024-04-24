package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.StudentDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public List<StudentDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody StudentDto dto){
        service.create(dto);
    }
}
