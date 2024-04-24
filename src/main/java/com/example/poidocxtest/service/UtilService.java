package com.example.poidocxtest.service;

import com.example.poidocxtest.entity.*;
import com.example.poidocxtest.repository.*;
import com.example.poidocxtest.service.mapper.util.UtilMapper;
import com.example.poidocxtest.util.ExaminationSheetCreator;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
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

    public ResponseEntity<ByteArrayResource> makeExaminationSheet (String groupCode, long subjectId, long secretaryId) throws Exception {
        try {
            Group group = groupRepository.findByGroupCode(groupCode)
                    .orElseThrow(() -> new RuntimeException("group not found"));
            Subjects subject = subjectsRepository.findById(subjectId)
                    .orElseThrow(() -> new RuntimeException("subject not found"));
            Speciality speciality = specialityRepository.findByGroupsContaining(group)
                    .orElseThrow(() -> new RuntimeException("speciality not found"));
            Faculty faculty = facultyRepository.findBySpecialitiesContaining(speciality)
                    .orElseThrow(() -> new RuntimeException("faculty not found"));
            Decanter decanter = decanterRepository.findByFaculty(faculty)
                    .orElseThrow(() -> new RuntimeException("decanter not found"));
            Department department = departmentRepository.findBySpecialitiesContaining(speciality)
                    .orElseThrow(() -> new RuntimeException("department not found"));
            Secretary secretary = secretaryRepository.findById(secretaryId)
                    .orElseThrow(() -> new RuntimeException("secretary not found"));

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "force-download"));
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=examination_sheet.docx");

            ExaminationSheetCreator examinationSheetCreator =
                    new ExaminationSheetCreator(
                            subject.getControlType(),
                            evidenceMapper.toDataDto(decanter,faculty,speciality,subject,group,department,secretary));
            XWPFDocument document = examinationSheetCreator.createExaminationSheet();
            document.write(stream);
            document.close();
            return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), headers, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
