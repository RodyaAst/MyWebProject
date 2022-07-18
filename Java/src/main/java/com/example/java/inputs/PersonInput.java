package com.example.java.inputs;

import com.example.java.types.SexType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonInput {

    private Long age;

    private Double bodyWeight;

    private Double creatinine;

    private SexType sex;

}
