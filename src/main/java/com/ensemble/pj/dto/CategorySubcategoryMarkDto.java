package com.ensemble.pj.dto;

import com.ensemble.pj.domain.CategorySubcategoryEntiity;

public class CategorySubcategoryMarkDto {

    private CategorySubcategoryEntiity id;
    private CategoryDto categoryDto;
    private SubcategoryDto subcategoryDto;
    private Double mark;

    public CategorySubcategoryEntiity getId() {
        return id;
    }

    public void setId(CategorySubcategoryEntiity id) {
        this.id = id;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public SubcategoryDto getSubcategoryDto() {
        return subcategoryDto;
    }

    public void setSubcategoryDto(SubcategoryDto subcategoryDto) {
        this.subcategoryDto = subcategoryDto;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this. mark = mark;
    }
}
