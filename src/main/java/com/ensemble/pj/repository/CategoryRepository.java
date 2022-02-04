package com.ensemble.pj.repository;

import com.ensemble.pj.domain.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    CategoryEntity findByCategoryName(String categoryName);
    CategoryEntity findById(UUID uuid);
    void deleteById(UUID uuid);
}
