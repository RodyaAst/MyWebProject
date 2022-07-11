package com.mywebapp.medicineproject.entities;

import com.mywebapp.medicineproject.base.BaseEntity;
import com.mywebapp.medicineproject.types.HealthStatusType;
import com.mywebapp.medicineproject.types.SexType;
import com.mywebapp.medicineproject.types.TransportationType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "med_cards")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MedicalCard extends BaseEntity {

    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "in_date")
    private LocalDate inDate;

    @Column(name = "out_date")
    private LocalDate outDate;

    @Column(name = "department")
    private String department;

    @Column(name = "ward")
    private String ward;

    @Column(name = "sum_days")
    private Long sumDays;

    @Column(name = "transportation_type")
    @Enumerated(EnumType.STRING)
    private TransportationType transportation;

    @Column(name = "drugs_side_effect")
    private String drugsSideEffect;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private SexType sex;

    @Column(name = "age")
    private Long age;

    @Column(name = "current_live")
    private String currentLive;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private HealthStatusType healthStatus;

    @OneToMany
    @JoinColumn(name = "med_card_id")
    private List<Drug> drugs;
}
