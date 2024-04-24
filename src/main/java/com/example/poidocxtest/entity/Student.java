package com.example.poidocxtest.entity;

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
@Table(name = "student")
public class Student{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @OneToOne
//    @JoinTable(
//            name = "student_record_book",
//            joinColumns = @JoinColumn(name = "record_book_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("recordBook")
    private RecordBook recordBook;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinTable(
//            name = "group_students",
//            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("students")
    private Group group;

    public String makeInitials(){
        return  surname + " " + name.charAt(0) + ". " + patronymic.charAt(0) + ".";
    }

    public String makeFullName(){
        return surname + " " + name + " " + patronymic;
    }
}
