package com.example.java.input_parser;

import com.example.java.entities.Person;
import com.example.java.entities.PersonAdditionalInfo;
import com.example.java.entities.PersonAdditionalPressure;
import com.example.java.entities.PersonAdditionalWeight;
import com.example.java.inputs.PersonInput;

public class PersonInputParser {

    public static Person fromInput(PersonInput input) {
        var person = Person.builder()
                .age(input.getAge())
                .bodyWeight(input.getBodyWeight())
                .length(input.getLength())
                .creatinine(input.getCreatinine())
                .sex(input.getSex())
                .personAdditionalInfo(PersonAdditionalInfo.builder()
                        .personAdditionalPressure(PersonAdditionalPressure.builder().build())
                        .personAdditionalWeight(PersonAdditionalWeight.builder().build())
                        .build())
                .build();
        return person;
    }

    public static void updateFromInput(Person person, PersonInput input) {
        person.setAge(input.getAge());
        person.setBodyWeight(input.getBodyWeight());
        person.setCreatinine(input.getCreatinine());
        person.setSex(input.getSex());
        person.setLength(input.getLength());
    }
}
