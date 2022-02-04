package com.ensemble.pj.domain;

import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.SubcategoryDto;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.ensemble.pj.domain.CategoryEntity.toCategoryDto;

@Entity
@Table(name = "subcategory")
public class SubcategoryEntity extends BaseEntity implements Serializable {

    private String subcategoryName;
    private double markSubcategory;

//    @ManyToOne
//    @JoinColumn(name="id_category")
//    private CategoryEntity categoryEntity;

//    @ManyToMany(mappedBy = "subcategoryEntities", fetch = FetchType.LAZY)
//    private List<CategoryEntity> categoryEntitties = new ArrayList<>();

    @OneToMany(mappedBy = "subcategoryEntity", cascade = CascadeType.ALL)
    private List<CategorySubcategoryMarkEntity> categorySubcategoryMarkEntities;

    // Constructors
    public SubcategoryEntity(String subcategoryName, double markSubcategory) {
        this.subcategoryName = subcategoryName;
        this.markSubcategory = markSubcategory;
    }

    public SubcategoryEntity() {}

    // Getters and Setters
    public String getSubcategoryName() {
        return subcategoryName;
    }
    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public double getMarkSubcategory() {
        return markSubcategory;
    }
    public void setMarkSubcategory(double markSubcategory) {
        this.markSubcategory = markSubcategory;
    }

    public List<CategorySubcategoryMarkEntity> getCategorySubcategoryMarkEntities() {
        return categorySubcategoryMarkEntities;
    }

    public void setCategorySubcategoryMarkEntities(List<CategorySubcategoryMarkEntity> categorySubcategoryMarkEntities) {
        if (this.categorySubcategoryMarkEntities == null) {
            this.categorySubcategoryMarkEntities = new ArrayList<>();
        }
        this.categorySubcategoryMarkEntities = categorySubcategoryMarkEntities;
    }

    public static SubcategoryDto toSubcategoryDto(SubcategoryEntity subcategoryEntity) {
        if (subcategoryEntity == null)
            return null;

        SubcategoryDto subcategory = new SubcategoryDto();

        subcategory.setId(subcategoryEntity.getIdString());
        subcategory.setSubcategoryName(subcategoryEntity.getSubcategoryName());

        subcategory.setMarkSubcategory(getMarkForSubcategory(subcategoryEntity));
        //subcategory.setCategoryDto(toCategoryDto(subcategoryEntity.getCategoryEntity()));

        return subcategory;
     }

    private static double getMarkForSubcategory(SubcategoryEntity subcategoryEntity) {
        if(subcategoryEntity.getCategorySubcategoryMarkEntities() == null){
            return 0;
        }else{
        for(CategorySubcategoryMarkEntity categorySubcategoryMarkEntity : subcategoryEntity.getCategorySubcategoryMarkEntities()) {
            if(categorySubcategoryMarkEntity.getSubcategoryEntity().getId() == subcategoryEntity.getId())
                return categorySubcategoryMarkEntity.getMark();
        }
        }
        return 0;
    }

//    public CategoryEntity getCategoryEntity() {
//        return categoryEntity;
//    }
//    public void setCategoryEntity(CategoryEntity categoryEntity) {
//        this.categoryEntity = categoryEntity;
//    }
}
