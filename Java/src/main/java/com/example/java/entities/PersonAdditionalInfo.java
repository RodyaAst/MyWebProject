package com.example.java.entities;

import com.example.java.base.BaseEntity;
import com.example.java.types.QueteletType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person_additional_info")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonAdditionalInfo extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_additional_weight_id")
    private PersonAdditionalWeight personAdditionalWeight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_additional_pressure_id")
    private PersonAdditionalPressure personAdditionalPressure;

}
