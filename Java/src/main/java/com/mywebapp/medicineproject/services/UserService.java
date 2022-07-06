package com.mywebapp.medicineproject.services;

import com.mywebapp.medicineproject.entities.User;
import com.mywebapp.medicineproject.inputs.UserInput;
import com.mywebapp.medicineproject.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(@NonNull UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(Long id) {
        return userRepository.getById(id);
    }

    public void addUser(UserInput user) {
        userRepository.addUser(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public List<User> findByFilters(String firstName, String lastName, LocalDate birthday, String currentFrom) {
        return userRepository.findByFilters(firstName, lastName, birthday, currentFrom);
    }
}
