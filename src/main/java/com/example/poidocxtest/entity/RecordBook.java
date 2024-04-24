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
@Table(name = "record_book")
public class RecordBook {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private String number;

    @OneToOne
//    @JoinTable(
//            name = "student_record_book",
//            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "record_book_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("recordBook")
    private Student student;

    @OneToMany
//    @JoinTable(
//            name = "record_book_subjects",
//            joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "record_book_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("recordBook")
    private List<Subjects> subjects  = new ArrayList<>();;
}
