package com.mywebapp.medicineproject.services;

import com.mywebapp.medicineproject.entities.MedicalCard;
import com.mywebapp.medicineproject.input_parser.MedicalCardInputParser;
import com.mywebapp.medicineproject.inputs.MedicalCardInput;
import com.mywebapp.medicineproject.repositories.MedicalCardRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;

    public MedicalCardService(@NonNull MedicalCardRepository medicalCardRepository) {
        this.medicalCardRepository = medicalCardRepository;
    }

    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardRepository.getAllMedicalCards();
    }

    public MedicalCard addMedicalCard(MedicalCardInput medicalCardInput) {
        var medicalCard = MedicalCardInputParser.fromInput(medicalCardInput);
        return medicalCardRepository.addMedicalCard(medicalCard);
    }
}
