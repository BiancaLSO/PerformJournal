package com.ensemble.pj.domain;

import com.ensemble.pj.dto.CategorySubcategoryMarkDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

import static com.ensemble.pj.domain.CategoryEntity.toCategoryDto;
import static com.ensemble.pj.domain.SubcategoryEntity.toSubcategoryDto;

@SuppressWarnings("ALL")
@Entity(name="CategorySubcategoryMarh")
@Table(name="category_subcategory_mark")
public class CategorySubcategoryMarkEntity implements Serializable {

    //used to serialize, deserialize objects of a Serializable class
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CategorySubcategoryEntiity id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("categoryEntityid")
    @JsonIgnoreProperties(value = "categorySubcategoriesMarksEntities", allowSetters = true)
    private CategoryEntity categoryEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("subcategoryEntityId")
    @JsonIgnoreProperties(value = "categorySubcategoriesMarksEntities", allowSetters = true)
    private SubcategoryEntity subcategoryEntity;

    @Column(name = "mark")
    private Double mark;

    public CategorySubcategoryMarkEntity(){}

    public CategorySubcategoryMarkEntity( CategoryEntity categoryEntity, SubcategoryEntity subcategoryEntity, Double mark) {
        this.id = new CategorySubcategoryEntiity(categoryEntity.getId(), subcategoryEntity.getId());
        this.categoryEntity = categoryEntity;
        this.subcategoryEntity = subcategoryEntity;
        this.mark = mark;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CategorySubcategoryEntiity getId() {
        return id;
    }
    public void setId(CategorySubcategoryEntiity id) {
        this.id = id;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }
    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public SubcategoryEntity getSubcategoryEntity() {
        return subcategoryEntity;
    }
    public void setSubcategoryEntity(SubcategoryEntity subcategoryEntity) {
        this.subcategoryEntity = subcategoryEntity;
    }

    public Double getMark() {
        return mark;
    }
    public void setMark(Double mark) {
        this.mark = mark;
    }

    public static CategorySubcategoryMarkDto toDto(CategorySubcategoryMarkEntity entity){

        CategorySubcategoryMarkDto dto = new CategorySubcategoryMarkDto();

        dto.setId(entity.getId());
        dto.setCategoryDto(toCategoryDto(entity.getCategoryEntity()));
        dto.setSubcategoryDto(toSubcategoryDto(entity.getSubcategoryEntity()));
        dto.setMark(entity.getMark());

        return dto;
    }
}
