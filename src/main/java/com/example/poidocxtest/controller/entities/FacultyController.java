package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.DepartmentDto;
import com.example.poidocxtest.dto.entities.FacultyDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.DepartmentService;
import com.example.poidocxtest.service.entities.FacultyService;
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
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyService service;

    @GetMapping
    public List<FacultyDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FacultyDto findById(@PathVariable @Min(0) long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid FacultyDto dto){
        service.create(dto);
    }
}
