package com.mywebapp.medicineproject.input_parser;

import com.mywebapp.medicineproject.entities.User;
import com.mywebapp.medicineproject.inputs.UserInput;

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
    }
}
