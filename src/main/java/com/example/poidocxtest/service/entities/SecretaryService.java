package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.SecretaryDto;
import com.example.poidocxtest.repository.SecretaryRepository;
import com.example.poidocxtest.service.mapper.entities.SecretaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecretaryService {
    private final SecretaryRepository secretaryRepo;
    private final SecretaryMapper secretaryMapper;

    public List<SecretaryDto> findAll(){
        return secretaryMapper.toDtoList(secretaryRepo.findAll());
    }

    public SecretaryDto findById(long id){
        return secretaryMapper.toDto(secretaryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("secretary not found")));
    }

    public void create(SecretaryDto dto){
        secretaryRepo.save(secretaryMapper.toEntity(dto));
    }
}
