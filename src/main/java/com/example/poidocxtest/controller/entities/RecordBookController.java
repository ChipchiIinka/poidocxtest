package com.example.poidocxtest.controller.entities;

import com.example.poidocxtest.dto.entities.RecordBookDto;
import com.example.poidocxtest.service.UtilService;
import com.example.poidocxtest.service.entities.RecordBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record_books")
@RequiredArgsConstructor
public class RecordBookController {
    private final RecordBookService service;

    @GetMapping
    public List<RecordBookDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RecordBookDto findById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody RecordBookDto dto){
        service.create(dto);
    }
}
