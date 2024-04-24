package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.SecretaryDto;
import com.example.poidocxtest.entity.Secretary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaryMapper {
    public List<SecretaryDto> toDtoList (List<Secretary> secretaries){
        return secretaries.stream().map(this::toDto).toList();
    }

    public SecretaryDto toDto (Secretary secretary){
        return SecretaryDto.builder()
                .surname(secretary.getSurname())
                .name(secretary.getName())
                .patronymic(secretary.getPatronymic())
                .build();
    }

    public Secretary toEntity (SecretaryDto dto){
        Secretary secretary = new Secretary();

        secretary.setSurname(dto.getSurname());
        secretary.setName(dto.getName());
        secretary.setPatronymic(dto.getPatronymic());

        return secretary;
    }
}
