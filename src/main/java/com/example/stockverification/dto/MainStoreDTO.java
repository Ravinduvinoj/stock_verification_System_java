package com.example.stockverification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainStoreDTO {
    @Id
    private int mainStoreId;
    private String mainStoreName;
    private String mainStoreCode;
}
