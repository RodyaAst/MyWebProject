package com.example.java.input_parser;

import com.example.java.entities.PersonAdditionalInfo;
import com.example.java.inputs.PersonAdditionalInfoInput;

public class PersonAdditionalInfoParser {

    public static PersonAdditionalInfo fromInput(PersonAdditionalInfoInput input) {
        var personAdditionalInfo = PersonAdditionalInfo.builder()
                .GFR(input.getGFR())
                .build();
        return personAdditionalInfo;
    }
}
