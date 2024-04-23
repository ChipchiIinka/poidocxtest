package com.example.poidocxtest.service;

import com.example.poidocxtest.entity.*;
import com.example.poidocxtest.repository.*;
import com.example.poidocxtest.service.mapper.util.UtilMapper;
import com.example.poidocxtest.util.ExaminationSheetCreator;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

    public void makeExaminationSheet (String groupCode, long subjectId, long secretaryId) throws Exception {

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

        ExaminationSheetCreator examinationSheetCreator =
                new ExaminationSheetCreator(
                        subject.getControlType(),
                        evidenceMapper.toDataDto(decanter,faculty,speciality,subject,group,department,secretary));
        XWPFDocument document = examinationSheetCreator.createExaminationSheet();
        OutputStream outputStream = new FileOutputStream("C:/Temporary/examination_sheet.docx");
        document.write(outputStream);
        document.close();
    }

}
