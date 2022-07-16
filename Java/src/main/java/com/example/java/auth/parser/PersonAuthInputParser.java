package com.example.java.auth.parser;

import com.example.java.auth.entity.PersonAuth;
import com.example.java.auth.input.PersonAuthInput;
import org.springframework.lang.NonNull;

public class PersonAuthInputParser {

    public static PersonAuth fromInput(@NonNull PersonAuthInput input) {
        return PersonAuth.builder()
                .username(input.getUsername())
                .birth_year(input.getBirth_year())
                .password(input.getPassword())
                .build();
    }
}
