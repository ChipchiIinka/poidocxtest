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

    @OneToOne
//    @JoinTable(
//            name = "faculty_decanter",
//            joinColumns = @JoinColumn(name = "decanter_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "faculty_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("faculty")
    private Decanter decanter;

    @OneToMany
//    @JoinTable(
//            name = "faculty_specialities",
//            joinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "faculty_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("faculty")
    private List<Speciality> specialities  = new ArrayList<>();

    @OneToMany
//    @JoinTable(
//            name = "faculty_teachers",
//            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "faculty_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("faculty")
    private List<Teacher> teachers  = new ArrayList<>();
}
