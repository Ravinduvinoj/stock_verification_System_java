package com.example.stockverification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "main_store")
public class Mainstore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mainStoreId;

    @Column(nullable = false)
    private String mainStoreName;

    @Column(nullable = false)
    private String mainStoreCode;
}
