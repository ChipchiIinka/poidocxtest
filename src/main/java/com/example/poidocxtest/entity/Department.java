package com.example.poidocxtest.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany
    @JoinColumn(name = "teachers")
    private Set<Teacher> teachers;

    @OneToOne
    @JoinColumn(name = "department_superintendent")
    private Teacher departmentSuperintendent;

    @OneToMany
    @JoinColumn(name = "specialities")
    private Set<Speciality> specialities;
}
