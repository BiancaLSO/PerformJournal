package com.ensemble.pj.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CategoryDto extends BaseDto{

    @Getter @Setter
    private String categoryName;

    @Getter @Setter
    private double categoryPercentage;

    @Getter @Setter
    private double markCategory;

    @Getter @Setter
    private List<SubcategoryDto> subcategories;
}
