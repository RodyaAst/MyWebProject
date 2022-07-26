package com.example.java.entities;

import com.example.java.base.BaseEntity;
import com.example.java.types.SexType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "person")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

    @Size(min = 2, max = 20)
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 20)
    @Column(name = "last_name")
    private String lastName;

    @Size(min = 2, max = 20)
    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private SexType sex;

    @Column(name = "birthdate")
    private LocalDate birthDate;

    @Column(name = "current_live")
    private String currentLive;

    @NotEmpty
    @Size(min = 10, max = 10)
    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "oms_code")
    private String OMSCode;

    @Column(name = "dms_code")
    private String DMSCode;

    @Column(name = "snils")
    private String SNILS;

    @Column(name = "job")
    private String job;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_body_info_id")
    private PersonBodyInfo personBodyInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_additional_id", nullable = false)
    private PersonAdditionalInfo personAdditionalInfo;

    public Integer getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
