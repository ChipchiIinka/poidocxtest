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
@Table(name = "decanter")
public class Decanter{
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
//            name = "faculty_decanter",
//            joinColumns = @JoinColumn(name = "faculty_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "decanter_id", referencedColumnName = "id")
//    )
    @JsonIgnoreProperties("decanter")
    private Faculty faculty;

    public String makeInitials(){
        return  surname + " " + name.charAt(0) + ". " + patronymic.charAt(0) + ".";
    }

    public String makeFullName(){
        return surname + " " + name + " " + patronymic;
    }
}
