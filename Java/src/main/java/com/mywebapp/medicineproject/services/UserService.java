package com.mywebapp.medicineproject.services;

import com.mywebapp.medicineproject.entities.User;
import com.mywebapp.medicineproject.input_parser.UserInputParser;
import com.mywebapp.medicineproject.inputs.UserInput;
import com.mywebapp.medicineproject.repositories.UserRepository;
import com.mywebapp.medicineproject.validations.UserValidation;
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
        return userRepository.addUser(userInput);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public List<User> findByFilters(String firstName, String lastName, LocalDate birthday, String currentFrom) {
        return userRepository.findByFilters(firstName, lastName, birthday, currentFrom);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    public void updateUser(User user, UserInput userInput) {
        UserInputParser.updateUserFromInput(user, userInput);
        userRepository.updateUser(user);
    }

}
