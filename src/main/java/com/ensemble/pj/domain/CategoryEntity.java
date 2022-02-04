package com.ensemble.pj.domain;

import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.SubcategoryDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.ensemble.pj.domain.SubcategoryEntity.toSubcategoryDto;


@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity implements Serializable {

    private String categoryName;
    private double categoryPercentage;
    private double markCategory;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    private List<CategorySubcategoryMarkEntity> categorySubcategoryMarkEntities;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<EmployeeEntity> employeeEntities = new ArrayList<>();

    // Constructors
    public CategoryEntity(String categoryName, double categoryPercentage, double markCategory) {
        this.categoryName = categoryName;
        this.categoryPercentage = categoryPercentage;
        this.markCategory = markCategory;
    }

    public CategoryEntity() {}

    // Getters and Setters

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public double getCategoryPercentage() { return categoryPercentage; }
    public void setCategoryPercentage(double categoryPercentage) { this.categoryPercentage = categoryPercentage; }

    public double getMarkCategory() { return markCategory; }
    public void setMarkCategory(double markCategory) { this.markCategory = markCategory; }

    public List<CategorySubcategoryMarkEntity> getCategorySubcategoryMarkEntities() {
        return categorySubcategoryMarkEntities;
    }

    public void setCategorySubcategoryMarkEntities(List<CategorySubcategoryMarkEntity> categorySubcategoryMarkEntities) {
        if(this.categorySubcategoryMarkEntities == null){
            this.categorySubcategoryMarkEntities = new ArrayList<>();
        }
        this.categorySubcategoryMarkEntities = categorySubcategoryMarkEntities;
    }

    //to Data Transfer Object
    public static CategoryDto toCategoryDto(CategoryEntity categoryEntity) {
        if(categoryEntity == null)
            return null;

        CategoryDto category = new CategoryDto();

        category.setId(categoryEntity.getIdString());
        category.setCategoryName(categoryEntity.getCategoryName());
        category.setCategoryPercentage(categoryEntity.getCategoryPercentage());
        category.setMarkCategory(categoryEntity.getMarkCategory());

        if(categoryEntity.getCategorySubcategoryMarkEntities() != null){
            List<SubcategoryDto> subcategories = categoryEntity.getCategorySubcategoryMarkEntities()
                    .stream()
                    .map(s -> toSubcategoryDto(s.getSubcategoryEntity())).collect(Collectors.toList());
            category.setSubcategories(subcategories);
        }
        // category.setSubcategories(getSubcategoryDtos(categoryEntity));

        return category;
    }
}
