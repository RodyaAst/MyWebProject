package com.example.java.entities;

import com.example.java.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person_additional_info")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonAdditionalInfo extends BaseEntity {

    @Column(name = "GFR")
    private Double GFR;
}
