package com.ensemble.pj.repository;

import com.ensemble.pj.domain.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity, Integer> {
    SubcategoryEntity findBySubcategoryName(String subcategoryName);
    SubcategoryEntity findById(UUID uuid);
    void deleteById(UUID uuid);
}
