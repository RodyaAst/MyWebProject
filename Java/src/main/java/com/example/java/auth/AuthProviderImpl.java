package com.example.java.auth;

import com.example.java.auth.service.PersonAuthService;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final PersonAuthService personAuthService;

    public AuthProviderImpl(@NonNull PersonAuthService personAuthService) {
        this.personAuthService = personAuthService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var username = authentication.getName();
        var userDetails = personAuthService.loadUserByUsername(username);
        var password = authentication.getCredentials().toString();
        var isPasswordCorrect = password.equals(userDetails.getPassword());
        if (!isPasswordCorrect) throw new BadCredentialsException("Пароль неверный");
        return new UsernamePasswordAuthenticationToken(userDetails, password, Collections.EMPTY_LIST);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
