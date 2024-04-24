package com.example.poidocxtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
//    @JoinTable(
//            name = "speciality_groups",
//            joinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("groups")
    private Speciality speciality;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "group_students",
//            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("students")
    private List<Student> students = new ArrayList<>();
}
