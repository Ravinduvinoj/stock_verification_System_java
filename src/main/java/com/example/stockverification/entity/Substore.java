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
public class Substore {
    @Id
    private int SubStoreId;
    private String SubStoreName;
    private String SubStoreCode;
}
