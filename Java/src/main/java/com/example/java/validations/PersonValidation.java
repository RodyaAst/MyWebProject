package com.example.java.validations;

import com.example.java.entities.Person;
import com.example.java.guard.Guard;
import org.springframework.stereotype.Component;

@Component
public class PersonValidation {

    public void validatePersonWhenCreating(Person person) {
        var isAgeCorrect = person.getAge() > 0
                && person.getAge() < 150;
        var isWeightCorrect = person.getPersonBodyInfo().getBodyWeight() > 0
                && person.getPersonBodyInfo().getBodyWeight() < 500;
        var isSexCorrect = person.getSex() != null;

        Guard.that(isAgeCorrect
                        && isWeightCorrect
                        && isSexCorrect,
                "error.incorrect.person.info",
                "Ошибка. Неверно указанные данные пациента.");
    }
}
