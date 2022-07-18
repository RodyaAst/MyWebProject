package com.example.java.entities;

import com.example.java.base.BaseEntity;
import com.example.java.types.DosageType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "drug")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Drug extends BaseEntity {

    @Column(name = "drug_name")
    private String name;

    @Column(name = "drug_dosage")
    private Double dosage;

    @Column(name = "drug_serial_id")
    private String serialId;

    @Column(name = "drug_dosage_name")
    private String dosageName;

    @Column(name = "drug_dosage_type")
    @Enumerated(EnumType.STRING)
    private DosageType drugDosageType;
}
