package com.example.java.controllers;

import com.example.java.inputs.PersonInput;
import com.example.java.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}/person")
    public ResponseEntity<?> getPerson(@NonNull @PathVariable Long id) {
        var person = personService.getPersonById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping("/person")
    public ResponseEntity<?> createPerson(@NonNull @RequestBody PersonInput input) {
        var person = personService.createPerson(input);
        return ResponseEntity.ok(person);
    }


    @GetMapping("/{id}/maxFondaparinuxDose")
    public ResponseEntity<?> isDrugUsable(@NonNull @PathVariable Long id,
                                          @NonNull @RequestParam String drugName) {
        var isDrugUsable = personService.isDrugUsable(id, drugName);
        return ResponseEntity.ok(isDrugUsable);
    }
}
