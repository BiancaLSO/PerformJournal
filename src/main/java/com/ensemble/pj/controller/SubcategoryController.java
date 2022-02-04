package com.ensemble.pj.controller;

import com.ensemble.pj.api.SubcategoryApi;
import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.SubcategoryDto;
import com.ensemble.pj.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class SubcategoryController implements SubcategoryApi {

    @Autowired
   private SubcategoryService subcategoryService;

    @Override
    public ResponseEntity<SubcategoryDto> getSubcategoryByName(String subcategoryName) {
        SubcategoryDto subcategory = subcategoryService.findSubcategoryByName(subcategoryName);
        return new ResponseEntity<>(subcategory, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubcategoryDto> createSubcategory(SubcategoryDto body) {
        SubcategoryDto subcategory = subcategoryService.createSubcategory(body);
        return new ResponseEntity<>(subcategory, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<SubcategoryDto> deleteSubcategory(String id) {
        SubcategoryDto subcategoryDto = subcategoryService.findSubcategoryById(id);
        subcategoryService.deleteSubcategory(id);
        return new ResponseEntity<>(subcategoryDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubcategoryDto> findSubcategoryById(String id) {
        SubcategoryDto subcategory= subcategoryService.findSubcategoryById(id);
        return new ResponseEntity<>(subcategory,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SubcategoryDto>> getAllSubcategories() {
        List<SubcategoryDto> subcategories = subcategoryService.getAllSubcategories();
        return new ResponseEntity<>(subcategories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubcategoryDto> mapCategoryToSubcategory(String id, CategoryDto body) {
        SubcategoryDto subcategoryDto = subcategoryService.addCategoryToSubcategory(id,body);
        return new ResponseEntity<>(subcategoryDto, HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<String> mapAllSubcategoriesToCategory(String categoryId) {
//        subcategoryService.addAllSubCategoriesToCategory(categoryId);
//        return new ResponseEntity<>("added successfully", HttpStatus.OK);
//    }

//    @Override
//    public ResponseEntity<List<CategoryDto>> mapAllSubcategoriesToAllCategories() {
//        List<CategoryDto> categoryDtos = subcategoryService.addAllSubcategoriesToAllCategories();
//        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
//    }
}
