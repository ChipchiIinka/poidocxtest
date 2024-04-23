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
@Table(name = "faculty")
public class Faculty {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "short_title")
    private String shortTitle;

    @ManyToOne
    @JoinColumn(name = "decanter")
    private Decanter decanter;

    @OneToMany
    @JoinColumn(name = "specialities")
    private Set<Speciality> specialities;

    @OneToMany
    @JoinColumn(name = "teachers")
    private Set<Teacher> teachers;
}
