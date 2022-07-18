package com.example.java.input_parser;

import com.example.java.entities.Person;
import com.example.java.inputs.PersonInput;

public class PersonInputParser {

    public static Person fromInput(PersonInput input) {
        var person = Person.builder()
                .age(input.getAge())
                .bodyWeight(input.getBodyWeight())
                .creatinine(input.getCreatinine())
                .sex(input.getSex())
                .build();
        return person;
    }
}
