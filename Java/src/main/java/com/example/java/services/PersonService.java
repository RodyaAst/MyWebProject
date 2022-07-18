package com.example.java.services;

import com.example.java.entities.Drug;
import com.example.java.entities.Person;
import com.example.java.guard.Guard;
import com.example.java.input_parser.PersonInputParser;
import com.example.java.inputs.PersonInput;
import com.example.java.repositories.DrugRepository;
import com.example.java.repositories.PersonRepository;
import com.example.java.types.DosageType;
import com.example.java.types.SexType;
import com.example.java.validations.PersonValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;
    private final DrugRepository drugRepository;
    private final PersonValidation personValidation;

    public PersonService(PersonRepository personRepository,
                         DrugRepository drugRepository,
                         PersonValidation personValidation) {
        this.personRepository = personRepository;
        this.drugRepository = drugRepository;
        this.personValidation = personValidation;
    }

    public Person getPersonById(Long id) {
        return personRepository.getById(id);
    }

    public Person createPerson(PersonInput input) {
        var person = PersonInputParser.fromInput(input);
        personValidation.validatePersonWhenCreating(person);
        addAdditionalInfo(person);
        return personRepository.save(person);
    }

    public void addAdditionalInfo(Person person) {
        addGFR(person);
    }

    public void addGFR(Person person) {
        var GFR = getGFR(person);
        person.getPersonAdditionalInfo().setGFR(GFR);
    }

    public Double getGFR(Person person) {
        Double sexCoefficient;

        if (person.getSex() == SexType.MALE) {
            sexCoefficient = 1D;
        } else {
            sexCoefficient = 0.85D;
        }

        Double GFR = ((140 - person.getAge()) * person.getBodyWeight()) / (person.getCreatinine() * 0.81) * sexCoefficient;

        Guard.that(GFR >= 0,
                "error.GFR.must.be.more.than.zero",
                "Ошибка. GFR должен быть больше нуля.");

        return GFR;
    }

    //////////////////////////////////////////////////////////////////////////////////////

    public Drug isDrugUsable(Long id, String drugName) {
        var person = personRepository.getById(id);
        var drugList = drugRepository.getDrugsByName(drugName);

        var GFR = person.getPersonAdditionalInfo().getGFR();

        if (GFR > 0
                && GFR < 15) {
            throw new RuntimeException("Нельзя использовать данное лекарство");
        } else if (GFR >= 15
                && GFR < 30) {
            return drugList.stream().filter(drug -> drug.getDosage() == 1.25D).findFirst().orElseThrow();
        } else if (GFR >= 30
                && GFR <= 90) {
            return drugList.stream().filter(drug -> drug.getDosage() == 2.5D).findFirst().orElseThrow();
        } else {
            throw new RuntimeException("Нельзя использовать данное лекарство");
        }
    }

    public Person updatePerson(Long id, PersonInput input) {
        var person = personRepository.getById(id);
        PersonInputParser.updateFromInput(person, input);
        addAdditionalInfo(person);
        personRepository.updatePerson(person);
        return person;
    }

    public void deleteUser(Long id) {
        var person = personRepository.getById(id);
        personRepository.deletePerson(person);
    }


    public boolean isDrugAvailable(Long personId, String drugName, Double dosage, DosageType dosageType) {
        var person = personRepository.getById(personId);
        var drug = drugRepository.getDrugsByNameAndDosage(drugName, dosage, dosageType);

        //TODO Drug Available Solver
        return false;
    }
}
