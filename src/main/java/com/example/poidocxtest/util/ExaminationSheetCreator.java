package com.example.poidocxtest.util;

import com.deepoove.poi.XWPFTemplate;
import com.example.poidocxtest.dto.examinationsheet.ExaminationSheetDto;
import com.example.poidocxtest.dto.examinationsheet.StudentSheetDto;
import com.example.poidocxtest.entity.enums.ControlType;
import org.apache.poi.xwpf.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class ExaminationSheetCreator {
    private static final int HEADER_ROW_QUANTITY_IN_TABLE = 3;
    private final XWPFDocument document;
    private final ExaminationSheetDto data;

    public ExaminationSheetCreator(ExaminationSheetDto data, ControlType type) throws IOException {
        InputStream template = type == ControlType.TEST
                ? this.getClass().getResourceAsStream("/test_examination_sheet.docx")
                : this.getClass().getResourceAsStream("/differentiated_test_examination_sheet.docx");
        assert template != null;
        document = new XWPFDocument(template);
        this.data = data;
    }

    public void createExaminationSheet() throws IOException {
        fillTables();
        fillTemplateValues();
    }

    private void fillTables() {
        fillGradeTable();
        fillStatisticalTable();
    }

    private void fillGradeTable() {
        XWPFTable gradeTable = document.getTables().get(0);
        List<StudentSheetDto> students = data.getStudents();

        for (int i = 0; i < data.getStudents().size(); i++) {
            gradeTable.createRow();
            try {
                XWPFTableCell number = gradeTable.getRow(i + HEADER_ROW_QUANTITY_IN_TABLE).getCell(0);
                number.addParagraph(createParagraph(
                        number.addParagraph(),
                        String.valueOf(i + 1)
                ));

                XWPFTableCell fullName = gradeTable.getRow(i + HEADER_ROW_QUANTITY_IN_TABLE).getCell(1);
                fullName.addParagraph(createParagraph(
                        fullName.addParagraph(),
                        students.get(i).getFullName()
                ));

                XWPFTableCell recordBookNumber = gradeTable.getRow(i + HEADER_ROW_QUANTITY_IN_TABLE).getCell(2);
                recordBookNumber.addParagraph(createParagraph(
                        recordBookNumber.addParagraph(),
                        students.get(i).getRecordBookNumber()
                ));

                XWPFTableCell grade = gradeTable.getRow(i + HEADER_ROW_QUANTITY_IN_TABLE).getCell(3);
                grade.addParagraph(createParagraph(
                        grade.addParagraph(),
                        students.get(i).getGrade()
                ));

                XWPFTableCell signature = gradeTable.getRow(i + HEADER_ROW_QUANTITY_IN_TABLE).getCell(4);
                signature.addParagraph(createParagraph(
                        signature.addParagraph(),
                        ""
                ));
            } catch (NullPointerException exception) {
                // 'cause merging cells doesn't create the correct number of tables cells
                gradeTable.getRow(i + HEADER_ROW_QUANTITY_IN_TABLE).createCell();

                XWPFTableCell signature = gradeTable.getRow(i + HEADER_ROW_QUANTITY_IN_TABLE).getCell(4);
                signature.addParagraph(createParagraph(
                        signature.addParagraph(),
                        ""
                ));
            }
        }
    }

    private XWPFParagraph createParagraph(XWPFParagraph paragraph, String text) {
        XWPFRun run = paragraph.createRun();

        // TODO: Fix the '\n' symbol in table cells when they are filled
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run.setFontFamily("Times New Roman");
        run.setFontSize(12);
        run.setText(text);

        return paragraph;
    }

    private void fillStatisticalTable() {
        // There's no need yet
    }

    private void fillTemplateValues() throws IOException {
        XWPFTemplate
                .compile(document)
                .render(new HashMap<String, Object>() {{
                    put("facultyShortName", data.getFacultyShortName());
                    put("deanName", data.getDeanName());
                    put("facultyFullName", data.getFacultyFullName());
                    put("specialityCode", data.getSpecialityCode());
                    put("period", data.getPeriod());
                    put("academicYear", data.getAcademicYear());
                    put("academicDisciplineTitle", data.getAcademicDisciplineTitle());
                    put("controlType", data.getControlType());
                    put("groupCode", data.getGroupCode());
                    put("departmentHeadName", data.getDepartmentHeadName());
                    put("secretaryName", data.getSecretaryName());
                    // A temporary measure until the merge with spring
                }}).writeToFile("C:/Temporary/examination_sheet.docx");
    }
}