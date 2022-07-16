package com.example.java.auth.controller;

import com.example.java.auth.input.PersonAuthInput;
import com.example.java.auth.service.PersonAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class PersonAuthController {

    private final PersonAuthService personAuthService;

    public PersonAuthController(@NonNull PersonAuthService personAuthService) {
        this.personAuthService = personAuthService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerPerson(@NonNull @RequestBody PersonAuthInput input) {
        var registeredPerson = personAuthService.registerPerson(input);
        return ResponseEntity.ok(registeredPerson);
    }
}
