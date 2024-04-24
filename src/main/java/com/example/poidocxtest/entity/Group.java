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
@Table(name = "study_group")
public class Group {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "group_code")
    private String groupCode;

    @ManyToOne
    @JoinColumn(name = "speciality")
    private Speciality speciality;

    @OneToMany
    @JoinColumn(name = "students")
    private Set<Student> students;
}
