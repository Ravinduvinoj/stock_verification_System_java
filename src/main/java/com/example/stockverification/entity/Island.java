package com.example.stockverification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Island {
    @Id
    private int IslandId;
    private String IslandName;
    private String IslandCode;

}
