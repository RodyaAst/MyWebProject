package com.example.java.auth.entity;

import com.example.java.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person_auth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonAuth extends BaseEntity {

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 10, message = "Имя должно быть длиной от 2 до 10 символов")
    @Column(name = "username")
    private String username;

    @Min(value = 1900, message = "Год рождения не может быть меньше 1900")
    @Column(name = "birth_year")
    private Long birth_year;

    @Size(min = 2, max = 10, message = "Пароль должен состоять из 2-10 символов")
    @Column(name = "password")
    private String password;
}
