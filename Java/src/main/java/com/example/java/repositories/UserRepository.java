package com.example.java.repositories;

import com.example.java.dao.Dao;
import com.example.java.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


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
//        var predicate = QPredicate.builder()
//                .add(firstName, QUser.firstName::eq)
//                .add(lastName, QUser.lastName::eq)
//                .add(birthday, QUser.birthdate::eq)
//                .add(currentFrom, QUser.currentFrom::eq)
//                .buildAnd();
//        return new JPAQuery<User>(session)
//                .select(QUser)
//                .from(QUser)
//                .where(predicate)
//                .fetch();
        return List.of();
    }

    public void deleteUser(User user) {
        dao.delete(user);
    }

    public void updateUser(User user) {
        dao.update(user);
    }
}
