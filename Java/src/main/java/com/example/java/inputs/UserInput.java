package com.example.java.inputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserInput {

    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String currentFrom;
    private JobInput job;
    private List<DocumentInput> documents;
}
