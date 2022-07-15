package com.example.java.services;

import com.example.java.entities.User;
import com.example.java.input_parser.UserInputParser;
import com.example.java.inputs.UserInput;
import com.example.java.repositories.UserRepository;
import com.example.java.validations.UserValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserValidation userValidation;

    public UserService(@NonNull UserRepository userRepository,
                       @NonNull UserValidation userValidation) {
        this.userRepository = userRepository;
        this.userValidation = userValidation;
    }

    public User findUser(Long id) {
        return userRepository.getById(id);
    }

    public User addUser(UserInput userInput) {
        userValidation.validateUser(userInput);
        var user = UserInputParser.fromInput(userInput);
        return userRepository.addUser(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public List<User> findByFilters(String firstName, String lastName, LocalDate birthday, String currentFrom) {
        return userRepository.findByFilters(firstName, lastName, birthday, currentFrom);
    }

    public void deleteUser(Long id) {
        var user = userRepository.getById(id);
        userRepository.deleteUser(user);
    }

    public void updateUser(Long id, UserInput userInput) {
        var user = userRepository.getById(id);
        UserInputParser.updateUserFromInput(user, userInput);
        userRepository.updateUser(user);
    }

}
