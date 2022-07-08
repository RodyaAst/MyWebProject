package com.mywebapp.medicineproject.guard;

import lombok.Getter;
import org.springframework.lang.NonNull;

@Getter
public class GuardException extends RuntimeException {

    private final String code;

    public GuardException(@NonNull String code,
                          @NonNull String message) {
        super(message, null);
        this.code = code;
    }
}
