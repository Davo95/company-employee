package com.example.companyemployeespring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    private double salary;
    @Enumerated(value = EnumType.STRING)
    private Position position;
    @Enumerated(value = EnumType.STRING)
    private RoleEmployee roleEmployee;
    @ManyToOne
    private Company company;

}
