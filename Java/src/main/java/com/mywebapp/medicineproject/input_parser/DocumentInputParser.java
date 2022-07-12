package com.mywebapp.medicineproject.input_parser;

import com.mywebapp.medicineproject.entities.Document;
import com.mywebapp.medicineproject.inputs.DocumentInput;

import java.util.ArrayList;
import java.util.List;

public class DocumentInputParser {

    public static Document fromInput(DocumentInput input) {
        var document = Document.builder()
                .name(input.getName())
                .createdAt(input.getCreatedAt())
                .data(input.getData())
                .build();
        return document;
    }

    public static List<Document> fromInputs(List<DocumentInput> input) {
        List<Document> documentList = new ArrayList<>();
        input.forEach(documentInput -> {
            var document = Document.builder()
                    .name(documentInput.getName())
                    .createdAt(documentInput.getCreatedAt())
                    .data(documentInput.getData())
                    .build();
            documentList.add(document);
        });
        return documentList;
    }
}
