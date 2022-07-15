package com.example.java.entities;

import com.example.java.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Job extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "since")
    private LocalDate since;

    @JsonBackReference
    @OneToOne(mappedBy = "job", cascade = CascadeType.ALL)
    private User user;
}
