package com.mywebapp.medicineproject.controllers;

import com.mywebapp.medicineproject.services.MedicalCardService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicalCard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    public MedicalCardController(@NonNull MedicalCardService medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @GetMapping("/medicalCards")
    public ResponseEntity<?> getAllMedicalCards() {
        try {
            var medicalCards = medicalCardService.getAllMedicalCards();
            log.info(medicalCards.toString());
            return ResponseEntity.ok(medicalCards);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
