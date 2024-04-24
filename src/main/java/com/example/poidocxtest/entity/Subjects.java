package com.example.poidocxtest.entity;

import com.example.poidocxtest.entity.enums.ControlType;
import com.example.poidocxtest.entity.enums.Grade;
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
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "record_book")
    private RecordBook recordBook;

    @Column(name = "grade")
    private Grade grade;
}

