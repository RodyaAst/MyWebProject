package com.example.java.repositories;

import com.example.java.dao.Dao;
import com.example.java.dao.QPredicate;
import com.example.java.entities.User;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.example.java.entities.QUser.user;


@Repository
@Slf4j
public class UserRepository {

    private final Dao dao;

    public UserRepository(@NonNull Dao dao) {
        this.dao = dao;
    }

    public User getById(Long id) {
        return dao.findById(User.class, id).orElseThrow();
    }

    public User addUser(User user) {
        return dao.add(user);
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

    public void deleteUser(User user) {
        dao.delete(user);
    }

    public void updateUser(User user) {
        dao.update(user);
    }
}
