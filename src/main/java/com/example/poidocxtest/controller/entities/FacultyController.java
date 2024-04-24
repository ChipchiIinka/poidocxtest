package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.DepartmentDto;
import com.example.poidocxtest.dto.entities.FacultyDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.DepartmentService;
import com.example.poidocxtest.service.entities.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public FacultyDto findById(@PathVariable long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody FacultyDto dto){
        service.create(dto);
    }
}
