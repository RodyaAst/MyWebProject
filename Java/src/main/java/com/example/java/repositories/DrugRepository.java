package com.example.java.repositories;

import com.example.java.dao.Dao;
import com.example.java.dao.QPredicate;
import com.example.java.entities.Drug;
import com.example.java.types.DosageType;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.java.entities.QDrug.drug;

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
        var session = dao.getSession();
        var predicate = QPredicate.builder()
                .add(name, drug.name::eq)
                .buildAnd();
        return new JPAQuery<Drug>(session)
                .select(drug)
                .from(drug)
                .where(predicate)
                .fetch();
    }

    public Drug getDrugsByNameAndDosage(String drugName, Double dosage, DosageType dosageType) {
        var session = dao.getSession();
        var predicate = QPredicate.builder()
                .add(drugName, drug.name::eq)
                .add(dosage, drug.dosage::eq)
                .add(dosageType, drug.drugDosageType::eq)
                .buildAnd();
        return new JPAQuery<Drug>(session)
                .select(drug)
                .from(drug)
                .where(predicate)
                .fetchFirst();
    }
}
