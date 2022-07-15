package com.example.java.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@OptimisticLocking(type = OptimisticLockType.VERSION)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private Long version;
}
