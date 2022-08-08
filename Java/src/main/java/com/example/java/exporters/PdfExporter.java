package com.example.java.exporters;

import org.apache.poi.ss.usermodel.Workbook;

public interface PdfExporter {
    Workbook buildXlsx();
}
