package com.example.java.auth.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonAuthInput {

    private String username;

    private Long birth_year;

    private String password;
}
