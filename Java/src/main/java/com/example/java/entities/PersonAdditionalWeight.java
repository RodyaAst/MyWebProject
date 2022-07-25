package com.example.java.entities;

import com.example.java.base.BaseEntity;
import com.example.java.types.QueteletType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person_additional_weight")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonAdditionalWeight extends BaseEntity {

    @Column(name = "gfr")
    private Integer GFR;

    @Column(name = "reference_weight")
    private Integer referenceWeight;

    @Column(name = "quetelet_index")
    @Enumerated(EnumType.STRING)
    private QueteletType queteletIndex;
}
