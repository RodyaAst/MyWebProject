package com.example.java.repositories;

import com.example.java.dao.Dao;
import com.example.java.entities.MedicalCard;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class MedicalCardRepository {

    private final Dao dao;

    public MedicalCardRepository(@NonNull Dao dao) {
        this.dao = dao;
    }

    public List<MedicalCard> getAllMedicalCards() {
        return dao.getAll(MedicalCard.class);
    }

    public MedicalCard addMedicalCard(MedicalCard medicalCard) {
        return dao.add(medicalCard);
    }

    public MedicalCard getMedicalCardById(Long id) {
        return dao.findById(MedicalCard.class, id).orElseThrow();
    }
}
