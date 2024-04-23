package com.example.poidocxtest.entity;

import com.example.poidocxtest.entity.enums.Position;
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
@EqualsAndHashCode(callSuper = true)
@Table(name = "teacher")
public class Teacher extends Human{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "position")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @OneToMany
    @JoinColumn(name = "subjects")
    private Set<Subjects> subjects;

    @ManyToOne
    @JoinColumn(name = "faculty")
    private Faculty faculty;
}
