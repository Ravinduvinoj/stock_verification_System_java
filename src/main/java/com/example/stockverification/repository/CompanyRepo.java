package com.example.stockverification.repository;

import com.example.stockverification.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Integer> {

    boolean existsByComCode(String comCode);
}
