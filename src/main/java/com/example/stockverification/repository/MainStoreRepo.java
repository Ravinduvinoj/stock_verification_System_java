package com.example.stockverification.repository;

import com.example.stockverification.entity.Mainstore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainStoreRepo extends JpaRepository<Mainstore,Integer> {
    Mainstore findByMainStoreCode(String mainStoreCode);
    boolean existsByMainStoreCode(String mainStoreCode);
}
