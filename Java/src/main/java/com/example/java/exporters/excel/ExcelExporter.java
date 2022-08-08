package com.example.java.exporters.excel;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelExporter {
    Workbook buildXlsx();
}
