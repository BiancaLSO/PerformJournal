package com.ensemble.pj.service;

import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.SubcategoryDto;
import com.ensemble.pj.helpers.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ComputationService {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubcategoryService subcategoryService;
    @Autowired
    private EmployeeService employeeService;

    public CategoryDto computeMarkForCategory(String id){
        CategoryDto categoryDto = categoryService.findCategoryById(id);
        //List<SubcategoryDto> subcategoryDtoList = categoryDto.getSubcategories();

//        double categoryMark = subcategoryDtoList.stream().mapToDouble(SubcategoryDto::getMarkSubcategory).sum() /
//                subcategoryDtoList.size();

        DecimalFormat df = new DecimalFormat("#.#");

       // return categoryService.updateCategoryMark(id, Double.parseDouble(df.format(categoryMark)));
        return null;
    }

    public List<CategoryDto> computeCategoryMarks(){
        List<CategoryDto> categories = categoryService.getAllCategories();

        for(CategoryDto categoryDto : categories){
            computeMarkForCategory(categoryDto.getId());

        }
        return categoryService.getAllCategories();
    }

    /*
    * Desc: Computes the overall mark considering Categories Marks and Their Weights
    */
    public double categoryWeightedAverage(){
        List<CategoryDto> categoryDtos = categoryService.getAllCategories();
        double weightedAverage = categoryDtos.stream().collect(Helper.averagingWeighted(
                                             CategoryDto::getMarkCategory, CategoryDto::getCategoryPercentage));
        return weightedAverage;
    }
}
