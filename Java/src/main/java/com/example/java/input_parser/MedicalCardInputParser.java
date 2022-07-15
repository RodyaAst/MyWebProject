package com.example.java.input_parser;

import com.example.java.entities.MedicalCard;
import com.example.java.inputs.MedicalCardInput;

public class MedicalCardInputParser {

    public static MedicalCard fromInput(MedicalCardInput input) {
        var medicineCard = MedicalCard.builder()
                .cardNumber(input.getCardNumber())
                .inDate(input.getInDate())
                .outDate(input.getOutDate())
                .department(input.getDepartment())
                .ward(input.getWard())
                .sumDays(input.getSumDays())
                .transportation(input.getTransportation())
                .drugsSideEffect(input.getDrugsSideEffect())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .patronymic(input.getPatronymic())
                .sex(input.getSex())
                .age(input.getAge())
                .currentLive(input.getCurrentLive())
                .diagnosis(input.getDiagnosis())
                .healthStatus(input.getHealthStatus())
                .drugs(DrugInputParser.fromInputs(input.getDrugs()))
                .build();
        return medicineCard;
    }
}
