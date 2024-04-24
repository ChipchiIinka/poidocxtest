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
@Table(name = "record_book")
public class RecordBook {
    @Id
    @Column(name = "id")
    private String id;

    @OneToOne
    @JoinColumn(name = "student")
    private Student student;

    @OneToMany
    @JoinColumn(name = "subjects")
    private Set<Subjects> subjects;
}
