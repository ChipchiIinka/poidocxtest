package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.DepartmentDto;
import com.example.poidocxtest.service.entities.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService service;

    @GetMapping
    public List<DepartmentDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentDto findById(@PathVariable long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DepartmentDto dto){
        service.create(dto);
    }
}
