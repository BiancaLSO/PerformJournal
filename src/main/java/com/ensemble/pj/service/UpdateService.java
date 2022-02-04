package com.ensemble.pj.service;

import com.ensemble.pj.domain.CategoryEntity;
import com.ensemble.pj.domain.CategorySubcategoryEntiity;
import com.ensemble.pj.domain.EmployeeEntity;
import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.CategorySubcategoryMarkDto;
import com.ensemble.pj.dto.EmployeeDto;
import com.ensemble.pj.dto.SubcategoryDto;
import com.ensemble.pj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UpdateService {

    @Autowired
    CategoryService categoryService;
    @Autowired
    SubcategoryService subcategoryService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CategorySubcategoryMarkService csmService;

    public CategorySubcategoryEntiity getKey(String categoryId, String subcategoryId){
        UUID categoryUuid = UUID.fromString(categoryId);
        UUID subcategoryUuid = UUID.fromString(subcategoryId);

       return new CategorySubcategoryEntiity(categoryUuid, subcategoryUuid);
    }


    public EmployeeDto updateFromBody(EmployeeDto body){

        List<CategorySubcategoryMarkDto> updated = new ArrayList<>();
        List<CategoryDto> updatedCategories = new ArrayList<>();
        List<SubcategoryDto> updatedSubcategories = new ArrayList<>();

        //get categories and update marks in cms repo
        List<CategoryDto> categoryDtos = body.getCategories();

        for (CategoryDto categoryDto : categoryDtos){
            Double categoryMark = categoryDto.getMarkCategory();
            //update category subcategory mark tuples in cms service
            List<SubcategoryDto> subcategoryDtos = categoryDto.getSubcategories();

            for(SubcategoryDto subcategoryDto : subcategoryDtos){
                Double subcategoryMark = subcategoryDto.getMarkSubcategory();
                CategorySubcategoryMarkDto dto = csmService.updateCategorySubcategoryMark(categoryDto, subcategoryDto, subcategoryMark);
                updatedSubcategories.add(dto.getSubcategoryDto());
            }

            categoryDto.setSubcategories(updatedSubcategories);
            updatedCategories.add(categoryService.updateCategoryMark(categoryDto,categoryMark));
        }

        // update employee entity
        //EmployeeDto updatedEmployee = employeeService.mapAllCategoriesToEmployee(body.getId());
        EmployeeDto updatedEmployee = employeeService.updateEmployeeCategories(body, updatedCategories);

        return updatedEmployee;
    }
}
