package com.example.stockverification.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor

@Data
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int comId;

    @Column(nullable = false, unique = true)
    private String comCode;

    @Column(nullable = false)
    private String companyName;
}
