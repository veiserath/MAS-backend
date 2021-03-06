package com.example.masimpl.Models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class CarDamage {
    @Id
    @GeneratedValue
    private Long id;

    String locationOfTheCarDamage;

    @ManyToOne
    private Car car;

    @ManyToOne
    private TechnicalService technicalService;

    @Enumerated
    private Severity severity;

    public String getDamageReport() {
        return toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarDamage that = (CarDamage) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

