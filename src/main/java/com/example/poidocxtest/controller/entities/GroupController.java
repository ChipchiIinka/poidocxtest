package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.FacultyDto;
import com.example.poidocxtest.dto.entities.GroupDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.FacultyService;
import com.example.poidocxtest.service.entities.GroupService;
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
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService service;

    @GetMapping
    public List<GroupDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GroupDto findById(@PathVariable @Min(0) long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid GroupDto dto){
        service.create(dto);
    }
}
