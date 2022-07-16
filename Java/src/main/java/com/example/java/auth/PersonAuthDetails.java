package com.example.java.auth;

import com.example.java.auth.entity.PersonAuth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class PersonAuthDetails implements UserDetails {

    private final PersonAuth personAuth;

    public PersonAuthDetails(PersonAuth personAuth) {
        this.personAuth = personAuth;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.personAuth.getPassword();
    }

    @Override
    public String getUsername() {
        return this.personAuth.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //Для получения данных аутентифицированного пользователя
    public PersonAuth getPersonAuth() {
        return this.personAuth;
    }
}
