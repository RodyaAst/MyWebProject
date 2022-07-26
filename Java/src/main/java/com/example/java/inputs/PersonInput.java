package com.example.java.inputs;

import com.example.java.types.SexType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonInput {

    private String firstName;

    private String lastName;

    private String patronymic;

    private SexType sex;

    private LocalDate birthDate;

    private String currentLive;

    private String passportNumber;

    private String omsCode;

    private String dmsCode;

    private String snils;

    private String job;

    private PersonBodyInfoInput bodyInfoInput;

}
