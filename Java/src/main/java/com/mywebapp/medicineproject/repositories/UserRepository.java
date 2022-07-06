package com.mywebapp.medicineproject.repositories;

import com.mywebapp.medicineproject.dao.Dao;
import com.mywebapp.medicineproject.dao.QPredicate;
import com.mywebapp.medicineproject.entities.User;
import com.mywebapp.medicineproject.inputs.UserInput;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.mywebapp.medicineproject.entities.QUser.user;

@Repository
@Slf4j
public class UserRepository {

    private final Dao dao;

    public UserRepository(@NonNull Dao dao) {
        this.dao = dao;
    }

    public User getById(Long id) {
        return dao.byId(User.class, id);
    }

    public void addUser(UserInput user) {
        dao.add(User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthdate(user.getBirthdate())
                .currentFrom(user.getCurrentFrom())
                .build());
    }

    public List<User> findAllUsers() {
        return dao.getAll(User.class);
    }

    public List<User> findByFilters(String firstName, String lastName, LocalDate birthday, String currentFrom) {
        var session = dao.getSession();
        var predicate = QPredicate.builder()
                .add(firstName, user.firstName::eq)
                .add(lastName, user.lastName::eq)
                .add(birthday, user.birthdate::eq)
                .add(currentFrom, user.currentFrom::eq)
                .buildAnd();
        return new JPAQuery<User>(session)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();
    }
}
