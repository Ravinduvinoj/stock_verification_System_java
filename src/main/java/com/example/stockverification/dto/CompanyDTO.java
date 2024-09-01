package com.example.stockverification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyDTO {

    @Id
    private int comId;
    private String comCode;
    private String companyName;
}