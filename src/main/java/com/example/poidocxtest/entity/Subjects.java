package com.example.poidocxtest.entity;

import com.example.poidocxtest.entity.enums.ControlType;
import com.example.poidocxtest.entity.enums.Grade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "subjects")
public class Subjects {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "control_type")
    private ControlType controlType;

    @Column(name = "semester")
    private Integer semester;

    @ManyToOne
//    @JoinTable(
//            name = "teacher_subjects",
//            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("subjects")
    private Teacher teacher;

    @ManyToOne
//    @JoinTable(
//            name = "record_book_subjects",
//            joinColumns = @JoinColumn(name = "record_book_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("subjects")
    private RecordBook recordBook;

    @Column(name = "grade")
    private Grade grade;
}

