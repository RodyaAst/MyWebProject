package com.example.java.entities;

import com.example.java.base.BaseEntity;
import com.example.java.types.SexType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

    @Column(name = "age")
    private Long age;

    @Column(name = "body_weight")
    private Double bodyWeight;

    @Column(name = "creatinine")
    private Double creatinine;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private SexType sex;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "person_additional_id")
    private PersonAdditionalInfo personAdditionalInfo;
}
