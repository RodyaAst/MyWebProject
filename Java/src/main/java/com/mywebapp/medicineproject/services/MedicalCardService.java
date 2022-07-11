package com.mywebapp.medicineproject.services;

import com.mywebapp.medicineproject.entities.MedicalCard;
import com.mywebapp.medicineproject.repositories.MedicalCardRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;

    public MedicalCardService(@NonNull MedicalCardRepository medicalCardRepository) {
        this.medicalCardRepository = medicalCardRepository;
    }

    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardRepository.getAllMedicalCards();
    }
}
