package com.example.java.input_parser;

import com.example.java.entities.User;
import com.example.java.inputs.UserInput;

public class UserInputParser {

    public static User fromInput(UserInput userInput) {
        var user = User.builder()
                .firstName(userInput.getFirstName())
                .lastName(userInput.getLastName())
                .birthdate(userInput.getBirthdate())
                .currentFrom(userInput.getCurrentFrom())
                .job(JobInputParser.fromInput(userInput.getJob()))
                .documents(DocumentInputParser.fromInputs(userInput.getDocuments()))
                .build();
        return user;
    }

    public static void updateUserFromInput(User user, UserInput userInput) {
        user.setFirstName(userInput.getFirstName());
        user.setLastName(userInput.getLastName());
        user.setBirthdate(userInput.getBirthdate());
        user.setCurrentFrom(userInput.getCurrentFrom());
        user.setJob(JobInputParser.fromInput(userInput.getJob()));
        user.setDocuments(DocumentInputParser.fromInputs(userInput.getDocuments()));
    }
}
