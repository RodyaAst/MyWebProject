package com.mywebapp.medicineproject.input_parser;

import com.mywebapp.medicineproject.entities.Drug;
import com.mywebapp.medicineproject.inputs.DrugInput;

import java.util.ArrayList;
import java.util.List;

public class DrugInputParser {

    public static Drug fromInput(DrugInput input) {
        var drug = Drug.builder()
                .name(input.getName())
                .dosage(input.getDosage())
                .serialId(input.getSerialId())
                .build();
        return drug;
    }


    public static List<Drug> fromInputs(List<DrugInput> input) {
        List<Drug> drugList = new ArrayList<>();
        input.forEach(drugInput -> {
            var drug = DrugInputParser.fromInput(drugInput);
            drugList.add(drug);
        });
        return drugList;
    }
}
