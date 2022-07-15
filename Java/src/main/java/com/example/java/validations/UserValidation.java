package com.example.java.validations;

import com.example.java.guard.Guard;
import com.example.java.inputs.UserInput;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    public void validateUser(UserInput userInput) {
        var firstName = userInput.getFirstName();
        var lastName = userInput.getLastName();
        var birthdate = userInput.getBirthdate();

        boolean isFirstNameCorrect = StringUtils.isNotBlank(firstName)
                && firstName.length() >= 2
                && StringUtils.isAlpha(firstName);
        boolean isLastNameCorrect = StringUtils.isNotBlank(lastName)
                && lastName.length() >= 2
                && StringUtils.isAlpha(lastName);
        Guard.that(isFirstNameCorrect
                && isLastNameCorrect, "incorrect.data",
                "First name or last Name is incorrect");
    }

}
