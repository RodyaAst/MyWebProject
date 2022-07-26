package com.example.java.input_parser;

import com.example.java.entities.*;
import com.example.java.inputs.PersonInput;

public class PersonInputParser {

    public static Person fromInput(PersonInput input) {
        var person = Person.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .patronymic(input.getPatronymic())
                .sex(input.getSex())
                .birthDate(input.getBirthDate())
                .currentLive(input.getCurrentLive())
                .passportNumber(input.getPassportNumber())
                .OMSCode(input.getOmsCode())
                .DMSCode(input.getDmsCode())
                .SNILS(input.getSnils())
                .job(input.getJob())
                .personBodyInfo(PersonBodyInfo.builder()
                        .bodyWeight(input.getBodyInfoInput().getBodyWeight())
                        .creatinine(input.getBodyInfoInput().getCreatinine())
                        .length(input.getBodyInfoInput().getLength())
                        .build())
                .personAdditionalInfo(PersonAdditionalInfo.builder()
                        .personAdditionalPressure(PersonAdditionalPressure.builder().build())
                        .personAdditionalWeight(PersonAdditionalWeight.builder().build())
                        .build())
                .build();
        return person;
    }

    public static void updateFromInput(Person person, PersonInput input) {
        person.setFirstName(input.getFirstName());
        person.setLastName(input.getLastName());
        person.setPatronymic(input.getPatronymic());
        person.setSex(input.getSex());
        person.setBirthDate(input.getBirthDate());
        person.setCurrentLive(input.getCurrentLive());
        person.setPassportNumber(input.getPassportNumber());
        person.setOMSCode(input.getOmsCode());
        person.setDMSCode(input.getDmsCode());
        person.setSNILS(input.getSnils());
        person.setJob(input.getJob());
        person.getPersonBodyInfo().setBodyWeight(input.getBodyInfoInput().getBodyWeight());
        person.getPersonBodyInfo().setLength(input.getBodyInfoInput().getLength());
        person.getPersonBodyInfo().setCreatinine(input.getBodyInfoInput().getCreatinine());
    }
}
