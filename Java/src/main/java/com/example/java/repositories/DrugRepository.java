package com.example.java.repositories;

import com.example.java.dao.Dao;
import com.example.java.entities.Drug;
import com.example.java.types.DosageType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DrugRepository {

    private final Dao dao;

    public DrugRepository(Dao dao) {
        this.dao = dao;
    }

    public Drug getDrugById(Long id) {
        return dao.findById(Drug.class, id).orElseThrow();
    }

    public List<Drug> getDrugsByName(String name) {
        //TODO HQL by filters
        return dao.getAll(Drug.class).stream().filter(drug -> drug.getName().equals(name)).collect(Collectors.toList());
    }

    public Drug getDrugsByNameAndDosage(String drugName, Double dosage, DosageType dosageType) {
        //TODO HQL by filters
        return dao.getAll(Drug.class).stream().filter(drug -> drug.getName().equals(drugName)
                && drug.getDosage() == dosage
                && drug.getDrugDosageType() == dosageType).findFirst().orElseThrow();
    }
}
