package com.example.poidocxtest.service.entities;

import com.example.poidocxtest.dto.entities.DecanterDto;
import com.example.poidocxtest.entity.Decanter;
import com.example.poidocxtest.repository.DecanterRepository;
import com.example.poidocxtest.repository.FacultyRepository;
import com.example.poidocxtest.service.mapper.entities.DecanterMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DecanterService {
    private final DecanterMapper decanterMapper;
    private final DecanterRepository decanterRepo;
    private final FacultyRepository facultyRepo;

    public List<DecanterDto> findAll (){
        return decanterMapper.toDtoList(decanterRepo.findAll());
    }

    public DecanterDto findById(long id){
        return decanterMapper.toDto(decanterRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("decanter not found")));
    }

    public void create(DecanterDto dto){
        Decanter decanter = decanterMapper.toEntity(dto);
        decanter.setFaculty(facultyRepo.findByTitle(dto.getFacultyTitle())
                .orElseThrow(() -> new RuntimeException("faculty not found")));

        decanterRepo.save(decanter);
    }
}
