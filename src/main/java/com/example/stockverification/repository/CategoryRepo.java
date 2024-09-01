package com.example.stockverification.repository;

import com.example.stockverification.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    boolean existsByCategoryCode(String categoryCode);
    Category findByCategoryCode(String categoryCode);
}