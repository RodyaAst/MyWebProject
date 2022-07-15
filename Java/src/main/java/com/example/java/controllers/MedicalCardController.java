package com.example.java.controllers;

import com.example.java.inputs.MedicalCardInput;
import com.example.java.services.MedicalCardService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}/medicalCard")
    public ResponseEntity<?> getMedicalCardById(@NonNull @PathVariable Long id) {
        try {
            var medicalCard = medicalCardService.getMedicalCard(id);
            log.info(medicalCard.toString());
            return ResponseEntity.ok(medicalCard);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/addMedicalCard")
    public ResponseEntity<?> addMedicalCard(@NonNull @RequestBody MedicalCardInput medicalCardInput) {
        var medicalCard = medicalCardService.addMedicalCard(medicalCardInput);
        log.info(medicalCard.toString());
        return ResponseEntity.ok(medicalCard);
    }

}
