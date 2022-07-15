package com.example.java.auth.repository;

import com.example.java.auth.PersonAuth;
import com.example.java.dao.Dao;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonAuthRepository {

    private final Dao dao;

    public PersonAuthRepository(@NonNull Dao dao) {
        this.dao = dao;
    }

    public Optional<PersonAuth> findByUsername(@NonNull String username) {
        return dao.getAll(PersonAuth.class).stream().filter(person -> username.equals(person.getUsername())).findFirst();
    }
}
