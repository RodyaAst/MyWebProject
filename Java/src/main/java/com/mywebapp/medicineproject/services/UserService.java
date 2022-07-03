package com.mywebapp.medicineproject.services;

import com.mywebapp.medicineproject.entities.User;
import com.mywebapp.medicineproject.inputs.UserInput;
import com.mywebapp.medicineproject.repositories.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
}
