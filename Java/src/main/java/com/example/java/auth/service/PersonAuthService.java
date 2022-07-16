package com.example.java.auth.service;

import com.example.java.auth.PersonAuthDetails;
import com.example.java.auth.entity.PersonAuth;
import com.example.java.auth.input.PersonAuthInput;
import com.example.java.auth.parser.PersonAuthInputParser;
import com.example.java.auth.repository.PersonAuthRepository;
import com.example.java.auth.validation.PersonAuthValidator;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonAuthService implements UserDetailsService {

    private final PersonAuthRepository personAuthRepository;
    private final PersonAuthValidator personAuthValidator;

    public PersonAuthService(@NonNull PersonAuthRepository personAuthRepository,
                             @NonNull PersonAuthValidator personAuthValidator) {
        this.personAuthRepository = personAuthRepository;
        this.personAuthValidator = personAuthValidator;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var person = personAuthRepository.findByUsername(username);

        if (person.isEmpty()) throw new UsernameNotFoundException("Имя пользователя не найдено");
        return new PersonAuthDetails(person.get());
    }

    public PersonAuth registerPerson(PersonAuthInput input) {
        var personAuth = PersonAuthInputParser.fromInput(input);
        personAuthValidator.validatePersonBeforeRegister(personAuth);
        return personAuthRepository.registerPerson(personAuth);
    }
}
