package com.example.exersise19.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "age cannot be null")
    private int age;
    @Email
    @NotEmpty(message = "email cannot be null")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @Column(columnDefinition = "int not null")
@NotNull(message = "salary cannot be null")
    private int salary;
    @OneToOne(cascade = CascadeType.ALL,mappedBy ="teacher")
    @PrimaryKeyJoinColumn
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> course;
}
