package com.example.java.repositories;

import com.example.java.dao.Dao;
import com.example.java.entities.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    private final Dao dao;

    public PersonRepository(Dao dao) {
        this.dao = dao;
    }

    public Person getById(Long id) {
        return dao.findById(Person.class, id).orElseThrow();
    }

    public List<Person> getAllPersons() {
        return dao.getAll(Person.class);
    }

    public Person save(Person person) {
        return dao.add(person);
    }

    public void deletePerson(Person person) {
        dao.delete(person);
    }

    public void updatePerson(Person person) {
        dao.update(person);
    }
}
