package com.mywebapp.medicineproject.repositories;

import com.mywebapp.medicineproject.dao.Dao;
import com.mywebapp.medicineproject.entities.User;
import com.mywebapp.medicineproject.inputs.UserInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<User> findByFilters() {
        var session = dao.getSession();
        return List.of();
    }
}
