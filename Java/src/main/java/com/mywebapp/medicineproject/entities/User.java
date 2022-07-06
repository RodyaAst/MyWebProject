package com.mywebapp.medicineproject.entities;

import com.mywebapp.medicineproject.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "current_from")
    private String currentFrom;

    @OneToOne
    @JoinColumn(name = "job_id")
    private Job job;
}
