package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.SecretaryDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.SecretaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretaries")
@RequiredArgsConstructor
public class SecretaryController {
    private final SecretaryService service;

    @GetMapping
    public List<SecretaryDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SecretaryDto findById(@PathVariable long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SecretaryDto dto){
        service.create(dto);
    }
}
