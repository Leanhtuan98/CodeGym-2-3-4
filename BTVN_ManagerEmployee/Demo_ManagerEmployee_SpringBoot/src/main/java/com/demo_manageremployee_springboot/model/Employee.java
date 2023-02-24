package com.demo_manageremployee_springboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private Double salary;

    @ManyToOne
    private Branch branch;
}
