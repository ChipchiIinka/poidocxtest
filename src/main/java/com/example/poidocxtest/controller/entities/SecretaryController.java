package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.SecretaryDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.SecretaryService;
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
@RequestMapping("/secretaries")
@RequiredArgsConstructor
public class SecretaryController {
    private final SecretaryService service;

    @GetMapping
    public List<SecretaryDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SecretaryDto findById(@PathVariable @Min(0) long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid SecretaryDto dto){
        service.create(dto);
    }
}
