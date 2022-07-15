package com.example.java.services;

import com.example.java.entities.MedicalCard;
import com.example.java.input_parser.MedicalCardInputParser;
import com.example.java.inputs.MedicalCardInput;
import com.example.java.repositories.MedicalCardRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public MedicalCard getMedicalCard(Long id) {
        return medicalCardRepository.getMedicalCardById(id);

    }
}
