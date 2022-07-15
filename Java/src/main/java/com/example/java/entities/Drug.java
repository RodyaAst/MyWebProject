package com.example.java.entities;

import com.example.java.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    private String dosage;

    @Column(name = "drug_serial_id")
    private String serialId;
}
