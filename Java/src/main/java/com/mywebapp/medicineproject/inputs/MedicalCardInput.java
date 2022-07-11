package com.mywebapp.medicineproject.inputs;

import com.mywebapp.medicineproject.types.HealthStatusType;
import com.mywebapp.medicineproject.types.SexType;
import com.mywebapp.medicineproject.types.TransportationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MedicalCardInput {

    private Long cardNumber;

    private LocalDate inDate;

    private LocalDate outDate;

    private String department;

    private String ward;

    private Long sumDays;

    private TransportationType transportation;

    private String drugsSideEffect;

    private String firstName;

    private String lastName;

    private String patronymic;

    private SexType sex;

    private Long age;

    private String currentLive;

    private String diagnosis;

    private HealthStatusType healthStatus;

    private List<DrugInput> drugs;
}
