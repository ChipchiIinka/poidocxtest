package com.example.poidocxtest.util;

import com.deepoove.poi.XWPFTemplate;
import com.example.poidocxtest.dto.examinationsheet.ExaminationSheetDto;
import com.example.poidocxtest.dto.examinationsheet.StudentSheetDto;
import com.example.poidocxtest.entity.enums.ControlType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class ExaminationSheetCreator {
    private static final int HEADER_ROW_QUANTITY_IN_TABLE = 3;
    private final XWPFDocument document;
    private final ExaminationSheetDto data;

    public ExaminationSheetCreator(ControlType type, ExaminationSheetDto data) throws IOException {
        InputStream template = type == ControlType.TEST
                ? this.getClass().getResourceAsStream("/test_examination_sheet.docx")
                : this.getClass().getResourceAsStream("/differentiated_test_examination_sheet.docx");

        if (template == null) {
            throw new FileNotFoundException("Examination sheet templates not found!");
        }

        document = new XWPFDocument(template);
        this.data = data;
    }

    public XWPFDocument createExaminationSheet() throws IOException, XmlException {
        fillTables();
        return fillTemplateValues();
    }

    private void fillTables() throws IOException, XmlException {
        fillGradeTable();
        fillStatisticalTable();
    }

    private void fillGradeTable() throws IOException, XmlException {
        XWPFTable gradeTable = document.getTables().get(0);
        List<StudentSheetDto> students = data.getStudents();

        XWPFStyles styles = document.createStyles();
        CTFonts fonts = CTFonts.Factory.newInstance();
        fonts.setAscii("Times New Roman");
        styles.setDefaultFonts(fonts);

        XWPFTableRow templateRow = gradeTable.getRow(HEADER_ROW_QUANTITY_IN_TABLE);
        CTRow formatting = CTRow.Factory.parse(templateRow.getCtRow().newInputStream());

        for (int i = 0; i < students.size(); i++) {
            XWPFTableRow row = new XWPFTableRow(formatting, gradeTable);

            row.getCell(0).setText(String.valueOf(i + 1));
            row.getCell(1).setText(students.get(i).getFullName());
            row.getCell(2).setText(students.get(i).getRecordBookNumber());
            row.getCell(3).setText(students.get(i).getGrade());
            row.getCell(4).setText("");

            gradeTable.addRow(row);
        }
        gradeTable.removeRow(HEADER_ROW_QUANTITY_IN_TABLE);
    }

    private void fillStatisticalTable() {
        // There's no need yet
    }

    private XWPFDocument fillTemplateValues() {
        return XWPFTemplate
                .compile(document)
                .render(new HashMap<String, Object>() {{
                    put("facultyShortName", data.getFacultyShortName());
                    put("deanName", data.getDeanName());
                    put("facultyFullName", data.getFacultyFullName());
                    put("specialityCode", createSpecialityCodeStringRequiredLength(data.getSpecialityCode()));
                    put("period", data.getPeriod());
                    put("academicYear", data.getAcademicYear());
                    put("academicDisciplineTitle", data.getAcademicDisciplineTitle());
                    put("controlType", data.getControlType());
                    put("groupCode", data.getGroupCode());
                    put("departmentHeadName", data.getDepartmentHeadName());
                    put("secretaryName", data.getSecretaryName());
                }}).getXWPFDocument();
    }

    private String createSpecialityCodeStringRequiredLength(String specialityCode) {
        StringBuilder specialityCodeBuilder = new StringBuilder(specialityCode);
        while (specialityCodeBuilder.length() < "{{specialityCode}}".length()) {
            specialityCodeBuilder.append("         ");
        }
        return specialityCodeBuilder.toString();
    }
}