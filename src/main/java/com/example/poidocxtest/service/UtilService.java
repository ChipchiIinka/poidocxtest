package com.example.poidocxtest.service;

import com.example.poidocxtest.entity.*;
import com.example.poidocxtest.repository.*;
import com.example.poidocxtest.service.mapper.util.UtilMapper;
import com.example.poidocxtest.util.ExaminationSheetCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UtilService {
    private final GroupRepository groupRepository;
    private final SubjectsRepository subjectsRepository;
    private final DecanterRepository decanterRepository;
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final SecretaryRepository secretaryRepository;
    private final SpecialityRepository specialityRepository;
    private final UtilMapper evidenceMapper;

    public void makeExaminationSheet (String groupCode, long subjectId, long secretaryId) throws IOException {

        Group group = groupRepository.findByGroupCode(groupCode)
                .orElseThrow(() -> new RuntimeException("group not found"));
        Subjects subject = subjectsRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("subject not found"));
        Speciality speciality = specialityRepository.findByGroup(group)
                .orElseThrow(() -> new RuntimeException("speciality not found"));
        Faculty faculty = facultyRepository.findBySpeciality(speciality)
                .orElseThrow(() -> new RuntimeException("faculty not found"));
        Decanter decanter = decanterRepository.findByFaculty(faculty)
                .orElseThrow(() -> new RuntimeException("decanter not found"));
        Department department = departmentRepository.findBySpeciality(speciality)
                .orElseThrow(() -> new RuntimeException("department not found"));
        Secretary secretary = secretaryRepository.findById(secretaryId)
                .orElseThrow(() -> new RuntimeException("secretary not found"));

        ExaminationSheetCreator examinationSheetCreator = new ExaminationSheetCreator(
                evidenceMapper.toDataDto(decanter,faculty,speciality,subject,group,department,secretary),
                subject.getControlType());
        examinationSheetCreator.createExaminationSheet();

    }


}
