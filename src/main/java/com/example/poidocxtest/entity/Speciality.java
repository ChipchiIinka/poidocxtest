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
//    @JoinTable(
//            name = "speciality_groups",
//            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("speciality")
    private List<Group> groups  = new ArrayList<>();;

    @ManyToOne
//    @JoinTable(
//            name = "department_specialities",
//            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("specialities")
    private Department department;

    @ManyToOne
//    @JoinTable(
//            name = "faculty_specialities",
//            joinColumns = @JoinColumn(name = "faculty_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("specialities")
    private Faculty faculty;
}

