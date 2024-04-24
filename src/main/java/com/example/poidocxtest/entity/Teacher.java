package com.example.poidocxtest.entity;

import com.example.poidocxtest.entity.enums.Position;
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
@Table(name = "teacher")
public class Teacher{
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

    @Column(name = "position")
    private Position position;

    @ManyToOne
//    @JoinTable(
//            name = "department_teachers",
//            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("teachers")
    private Department department;

    @OneToMany
//    @JoinTable(
//            name = "teacher_subjects",
//            joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("teacher")
    private List<Subjects> subjects  = new ArrayList<>();;

    @ManyToOne
//    @JoinTable(
//            name = "faculty_teachers",
//            joinColumns = @JoinColumn(name = "faculty_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("teachers")
    private Faculty faculty;

    public String makeInitials(){
        return  surname + " " + name.charAt(0) + ". " + patronymic.charAt(0) + ".";
    }

    public String makeFullName(){
        return surname + " " + name + " " + patronymic;
    }
}
