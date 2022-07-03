package com.mywebapp.medicineproject.repositories;

import com.mywebapp.medicineproject.dao.Dao;
import com.mywebapp.medicineproject.entities.User;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final Dao dao;

    public UserRepository(@NonNull Dao dao) {
        this.dao = dao;
    }

    public User getById(Long id) {
        return dao.byId(User.class, id);
    }

    public void addUser(String name) {
        dao.add(User.builder().name(name).build());
    }
}
