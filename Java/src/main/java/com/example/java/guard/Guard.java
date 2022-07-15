package com.example.java.guard;

public abstract class Guard {

    public static void that(boolean condition, String code, String message) {
        if (!condition) {
            throw new GuardException(code, message);
        }
    }
}
