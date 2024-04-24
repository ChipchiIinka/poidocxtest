package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.SecretaryDto;
import com.example.poidocxtest.dto.entities.SpecialityDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.SecretaryService;
import com.example.poidocxtest.service.entities.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialities")
@RequiredArgsConstructor
public class SpecialityController {
    private final SpecialityService service;

    @GetMapping
    public List<SpecialityDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SpecialityDto findById(@PathVariable long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SpecialityDto dto){
        service.create(dto);
    }
}