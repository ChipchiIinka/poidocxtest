package com.example.poidocxtest.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "speciality")
public class Speciality {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "speciality_code")
    private String specialityCode;

    @OneToMany
    @JoinColumn(name = "group")
    private Set<Group> groups;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "faculty")
    private Faculty faculty;

    @OneToMany
    @JoinColumn(name = "students")
    private Set<Student> students;
}

