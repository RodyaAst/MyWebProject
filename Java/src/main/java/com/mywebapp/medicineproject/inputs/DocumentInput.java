package com.mywebapp.medicineproject.inputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DocumentInput {

    private String name;
    private LocalDate createdAt;
    private String data;
}
