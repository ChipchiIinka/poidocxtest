package com.example.poidocxtest.entity;

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
    @JoinColumn(name = "record_book")
    private RecordBook recordBook;

    @ManyToOne
    @JoinColumn(name = "study_group")
    private Group group;

    public String makeInitials(){
        return  surname + " " + name.charAt(0) + ". " + patronymic.charAt(0) + ".";
    }

    public String makeFullName(){
        return surname + " " + name + " " + patronymic;
    }
}
