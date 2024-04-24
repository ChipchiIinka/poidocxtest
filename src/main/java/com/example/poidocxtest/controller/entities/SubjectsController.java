package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.SubjectsDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.SubjectsService;
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
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectsController {
    private final SubjectsService service;

    @GetMapping
    public List<SubjectsDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SubjectsDto findById(@PathVariable @Min(0) long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid SubjectsDto dto){
        service.create(dto);
    }
}
