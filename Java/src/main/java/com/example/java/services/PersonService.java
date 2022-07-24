package com.example.java.services;

import com.example.java.entities.Drug;
import com.example.java.entities.Person;
import com.example.java.guard.Guard;
import com.example.java.input_parser.PersonInputParser;
import com.example.java.inputs.PersonInput;
import com.example.java.repositories.DrugRepository;
import com.example.java.repositories.PersonRepository;
import com.example.java.types.DosageType;
import com.example.java.types.QueteletType;
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

    private void addAdditionalInfo(Person person) {
        addGFR(person);
        addReferenceWeight(person);
        addQueteletIndex(person);
        addReferencePressure(person);
    }

    private void addGFR(Person person) {
        var GFR = getGFR(person);
        person.getPersonAdditionalInfo().getPersonAdditionalWeight().setGFR(GFR);
    }

    private void addReferenceWeight(Person person) {
        var referenceWeight = getReferenceWeight(person);
        person.getPersonAdditionalInfo().getPersonAdditionalWeight().setReferenceWeight(referenceWeight);
    }

    private void addQueteletIndex(Person person) {
        var queteletIndex =  getQueteletIndex(person);
        person.getPersonAdditionalInfo().getPersonAdditionalWeight().setQueteletIndex(queteletIndex);
    }

    private void addReferencePressure(Person person) {
        var referencePressureSystolic = getReferencePressureSystolic(person);
        var referencePressureDiastolic = getReferencePressureDiastolic(person);

        person.getPersonAdditionalInfo().getPersonAdditionalPressure().setReferencePressureSystolic(referencePressureSystolic);
        person.getPersonAdditionalInfo().getPersonAdditionalPressure().setReferencePressureDiastolic(referencePressureDiastolic);
    }

    private Double getGFR(Person person) {
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

    private Double getReferenceWeight(Person person) {
        Double sexCoefficient;

        if (person.getSex() == SexType.MALE) {
            sexCoefficient = 100d;
        } else {
            sexCoefficient = 110d;
        }
        var length = person.getLength() * 100;
        return (length - 110d) * 1.15d;
    }

    private QueteletType getQueteletIndex(Person person) {
        Double sexCoefficient;

        if (person.getSex() == SexType.MALE) {
            sexCoefficient = 100d;
        } else {
            sexCoefficient = 110d;
        }

        var weight = person.getBodyWeight() * 1000;
        var length = person.getLength() * 100d;

        var index = (long)(weight / length);

        return QueteletType.getQueteletTypeByIndexAndSexType(index, person.getSex());
    }

    private Double getReferencePressureSystolic(Person person) {
        //TODO Расчет идеального давления

        return null;
    }

    private Double getReferencePressureDiastolic(Person person) {
        //TODO Расчет идеального давления

        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////

    public Drug isDrugUsable(Long id, String drugName) {
        var person = personRepository.getById(id);
        var drugList = drugRepository.getDrugsByName(drugName);

        var GFR = person.getPersonAdditionalInfo().getPersonAdditionalWeight().getGFR();

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
