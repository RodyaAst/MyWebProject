package com.mywebapp.medicineproject.inputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobInput {

    private String name;
    private Long salary;
    private LocalDate since;
}
