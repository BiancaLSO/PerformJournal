package com.ensemble.pj.controller;

import com.ensemble.pj.api.CategoryApi;
import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<CategoryDto> getCategoryByName(String categoryName) {
        CategoryDto category = categoryService.findCategoryByName(categoryName);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDto> createCategory(CategoryDto body) {
        CategoryDto category = categoryService.createCategory(body);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<CategoryDto> deleteCategory(CategoryDto body) {
        categoryService.deleteCategory(body);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDto> findCategoryById(String id) {
        CategoryDto category= categoryService.findCategoryById(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteCategoryById(String id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>("Deleted item with id" + id, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<CategoryDto> updateCategoryPercentage(String id, Double newPercentage) {
//        CategoryDto category = categoryService.updateCategoryPercentage(id, newPercentage);
//        return new ResponseEntity<>(category,HttpStatus.OK);
//    }

//    @Override
//    public ResponseEntity<CategoryDto> mapAllSubcategoriesToCategory(String categoryId) {
//        categoryService.addAllSubCategoriesToCategory(categoryId);
//        CategoryDto categoryDto = categoryService.findCategoryById(categoryId);
//        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<List<CategoryDto>> mapAllSubcategoriesToAllCategories() {
//        List<CategoryDto> categoryDtos = categoryService.addAllSubcategoriesToAllCategories();
//        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
 //   }

}
