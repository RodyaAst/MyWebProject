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

    @Column(name = "gfr")
    private Double GFR;

    @Column(name = "reference_weight")
    private Double referenceWeight;

    @Column(name = "reference_pressure")
    private Long referencePressure;

    @Column(name = "quetelet_index")
    @Enumerated(EnumType.STRING)
    private QueteletType queteletIndex;
}
