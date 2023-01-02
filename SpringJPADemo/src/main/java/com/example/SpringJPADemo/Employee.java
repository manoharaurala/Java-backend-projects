package com.example.SpringJPADemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String name;

    @Column
    private Double salary;

    @OneToOne
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("employeeSet")
    private Branch branch;


}
