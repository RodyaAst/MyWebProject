package com.example.java.entities;

import com.example.java.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Document extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "data")
    private String data;
}
