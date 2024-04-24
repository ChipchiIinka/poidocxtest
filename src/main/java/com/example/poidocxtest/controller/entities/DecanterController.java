package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.DecanterDto;
import com.example.poidocxtest.service.entities.DecanterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decanters")
@RequiredArgsConstructor
public class DecanterController {
    private final DecanterService service;

    @GetMapping
    public List<DecanterDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DecanterDto findById(@PathVariable long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DecanterDto dto){
        service.create(dto);
    }
}
