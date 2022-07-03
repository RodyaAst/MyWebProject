package com.mywebapp.medicineproject.inputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserInput {

    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String currentFrom;
    private JobInput job;
}
