package com.mywebapp.medicineproject.entities;

import com.mywebapp.medicineproject.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

}
