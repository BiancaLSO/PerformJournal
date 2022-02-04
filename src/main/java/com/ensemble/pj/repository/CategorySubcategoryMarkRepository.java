package com.ensemble.pj.repository;

import com.ensemble.pj.domain.CategorySubcategoryEntiity;
import com.ensemble.pj.domain.CategorySubcategoryMarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategorySubcategoryMarkRepository extends JpaRepository<CategorySubcategoryMarkEntity, Long> {
    CategorySubcategoryMarkEntity findById(CategorySubcategoryEntiity id);
    CategorySubcategoryMarkEntity findByCategoryEntityIdAndSubcategoryEntityId(UUID categoryId, UUID subcategoryId);
}
