package com.example.java.entities;

import com.example.java.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person_additional_pressure")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonAdditionalPressure extends BaseEntity {

    @Column(name = "reference_pressure_systolic")
    private Double referencePressureSystolic;

    @Column(name = "reference_pressure_diastolic")
    private Double referencePressureDiastolic;
}
