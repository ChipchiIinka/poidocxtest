package com.example.poidocxtest.service.mapper.entities;

import com.example.poidocxtest.dto.entities.DecanterDto;
import com.example.poidocxtest.entity.Decanter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecanterMapper {
    public List<DecanterDto> toDtoList (List<Decanter> decanters){
        return decanters.stream().map(this::toDto).toList();
    }

    public DecanterDto toDto (Decanter decanter){
        return DecanterDto.builder()
                .surname(decanter.getSurname())
                .name(decanter.getName())
                .patronymic(decanter.getPatronymic())
                .facultyTitle(decanter.getFaculty().getTitle())
                .build();
    }

    public Decanter toEntity (DecanterDto dto){
        Decanter decanter = new Decanter();

        decanter.setSurname(dto.getSurname());
        decanter.setName(dto.getName());
        decanter.setPatronymic(dto.getPatronymic());

        return decanter;
    }
}
