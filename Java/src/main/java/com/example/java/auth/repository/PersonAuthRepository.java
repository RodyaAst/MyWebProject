package com.example.java.auth.repository;

import com.example.java.auth.entity.PersonAuth;
import com.example.java.auth.entity.QPersonAuth;
import com.example.java.dao.Dao;
import com.example.java.dao.QPredicate;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.java.auth.entity.QPersonAuth.personAuth;

@Repository
public class PersonAuthRepository {

    private final Dao dao;

    public PersonAuthRepository(@NonNull Dao dao) {
        this.dao = dao;
    }

    public Optional<PersonAuth> findByUsername(@NonNull String username) {
        var session = dao.getSession();
        var predicate = QPredicate.builder()
                .add(username, personAuth.username::eq)
                .buildAnd();
        var auth = new JPAQuery<PersonAuth>(session)
                .select(QPersonAuth.personAuth)
                .from(QPersonAuth.personAuth)
                .where(predicate)
                .fetchOne();
        return Optional.ofNullable(auth);
    }

    public PersonAuth registerPerson(PersonAuth personAuth) {
        return dao.add(personAuth);
    }
}
