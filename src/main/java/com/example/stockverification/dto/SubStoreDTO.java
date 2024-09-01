package com.example.stockverification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubStoreDTO {
    @Id
    private int SubStoreId;
    private String SubStoreName;
    private String SubStoreCode;
}
