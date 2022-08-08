package com.example.java.exporters;

import com.example.java.entities.Person;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class PersonPdfExporter implements PdfExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Person> personList;

    public PersonPdfExporter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public Workbook buildXlsx() {
        workbook = new XSSFWorkbook();

        writeHeaderLine();
        writeDataLines();

        return workbook;
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Person List");

        var row = sheet.createRow(0);

        var style = workbook.createCellStyle();
        var font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Имя", style);
        createCell(row, 1, "Фамилия", style);
        createCell(row, 2, "Отчество", style);
        createCell(row, 3, "Пол", style);
        createCell(row, 4, "Место жительства", style);

    }

    private void writeDataLines() {
        int rowCount = 1;

        var style = workbook.createCellStyle();
        var font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Person person : personList) {
            var row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, person.getFirstName(), style);
            createCell(row, columnCount++, person.getLastName(), style);
            createCell(row, columnCount++, person.getPatronymic(), style);
            createCell(row, columnCount++, person.getSex().toString(), style);
            createCell(row, columnCount++, person.getCurrentLive(), style);

        }
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        var cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
}
