package com.example.java.repositories;

import com.example.java.dao.Dao;
import com.example.java.entities.Drug;
import com.example.java.types.DosageType;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        var query = dao.getSession().createQuery("from Drug d where d.name = :drugName");
        query.setParameter("drugName", name);
        List<Drug> drugs = query.list();
        return drugs;
    }

    public Drug getDrugsByNameAndDosage(String drugName, Double dosage, DosageType dosageType) {
        var query = dao.getSession().createQuery("from Drug d where  d.name = :drugName " +
                "and d.dosage = :dosage and d.drugDosageType = :dosageType");
        query.setParameter("drugName", drugName)
                .setParameter("dosage", dosage)
                .setParameter("dosageType", dosageType);
        var drug = (Drug) query.getSingleResult();
        return drug;
    }
}
