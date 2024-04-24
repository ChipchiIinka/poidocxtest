package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.TeacherDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.TeacherService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService service;

    @GetMapping
    public List<TeacherDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TeacherDto findById(@PathVariable @Min(0) long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid TeacherDto dto){
        service.create(dto);
    }
}
