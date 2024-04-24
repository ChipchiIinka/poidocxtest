package com.example.poidocxtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
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
//    @JoinTable(
//            name = "department_teachers",
//            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("department")
    private List<Teacher> teachers = new ArrayList<>();

    @OneToOne
//    @JoinColumn(name = "department_superintendent")
    @JsonIgnoreProperties("department")
    private Teacher departmentSuperintendent;

    @OneToMany
//    @JoinTable(
//            name = "department_specialities",
//            joinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("department")
    private List<Speciality> specialities = new ArrayList<>();
}
