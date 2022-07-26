package com.example.java.entities;

import com.example.java.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person_body_info")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonBodyInfo extends BaseEntity {

    @Column(name = "body_weight")
    private Double bodyWeight;

    @Column(name = "length")
    private Double length;

    @Column(name = "creatinine")
    private Double creatinine;

}
