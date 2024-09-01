package com.example.stockverification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {
    @Id
    private int categoryID;
    private String categoryCode;
    private String categoryName;
}
