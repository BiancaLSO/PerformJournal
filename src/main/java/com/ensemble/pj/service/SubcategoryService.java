package com.ensemble.pj.service;

import com.ensemble.pj.domain.CategoryEntity;
import com.ensemble.pj.domain.SubcategoryEntity;
import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.SubcategoryDto;
import com.ensemble.pj.repository.CategoryRepository;
import com.ensemble.pj.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.ensemble.pj.domain.SubcategoryEntity.toSubcategoryDto;
import static com.ensemble.pj.domain.CategoryEntity.toCategoryDto;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public SubcategoryDto createSubcategory(SubcategoryDto subcategoryDto) {
        SubcategoryEntity subcategoryEntity = new SubcategoryEntity();

        subcategoryEntity.setSubcategoryName(subcategoryDto.getSubcategoryName());
        subcategoryEntity.setMarkSubcategory(subcategoryDto.getMarkSubcategory());

        subcategoryRepository.saveAndFlush(subcategoryEntity);

        return toSubcategoryDto(subcategoryEntity);
    }

    public SubcategoryDto findSubcategoryById(String id) {
        UUID uuid = UUID.fromString(id);
        SubcategoryEntity subcategoryEntity = subcategoryRepository.findById(uuid);
        return toSubcategoryDto(subcategoryEntity);
    }

    public SubcategoryEntity findSubcategoryEntityById(String id) {
        UUID uuid = UUID.fromString(id);
        SubcategoryEntity subcategoryEntity = subcategoryRepository.findById(uuid);
        return subcategoryEntity;
    }

    //add exception
    public SubcategoryDto findSubcategoryByName(String subcategoryName) {
        SubcategoryEntity subcategoryEntity = subcategoryRepository.findBySubcategoryName(subcategoryName);
        return toSubcategoryDto(subcategoryEntity);
    }

    public void deleteSubcategory(String id) {
        subcategoryRepository.deleteById(UUID.fromString(id));
    }

    public List<SubcategoryDto> getAllSubcategories() {
        List<SubcategoryEntity> subcategoryEntities = subcategoryRepository.findAll();
        List<SubcategoryDto> subcategories = new ArrayList<>();

        for (SubcategoryEntity subcategoryEntity: subcategoryEntities) {
            subcategories.add(toSubcategoryDto(subcategoryEntity));
        }

        return subcategories;
    }

    public SubcategoryDto addCategoryToSubcategory(String subcategoryId, CategoryDto categoryDto) {
        UUID subcategoryUUID = UUID.fromString(subcategoryId);
        UUID categoryUUID = UUID.fromString(categoryDto.getId());

        SubcategoryEntity subcategoryEntity = subcategoryRepository.findById(subcategoryUUID);
        CategoryEntity categoryEntity = categoryRepository.findById(categoryUUID);

        //subcategoryEntity.setCategoryEntity(categoryEntity);
        subcategoryRepository.save(subcategoryEntity);

        return toSubcategoryDto(subcategoryEntity);
    }

    public SubcategoryDto updateSubcqtegoryMark(SubcategoryDto subcategoryDto){
        SubcategoryEntity subcategoryEntity = subcategoryRepository.findById(UUID.fromString(subcategoryDto.getId()));
        subcategoryRepository.save(subcategoryEntity);

        return toSubcategoryDto(subcategoryEntity);
    }

//    public void addSubcategoryEntityToCategoryEntity(SubcategoryEntity subcategoryEntity, CategoryEntity categoryEntity){
//        //subcategoryEntity.setCategoryEntity(categoryEntity);
//        subcategoryRepository.save(subcategoryEntity);
//    }
//
//    public void addAllSubCategoriesToCategory(String categoryId){
//        CategoryEntity categoryEntity = categoryRepository.findById(UUID.fromString(categoryId));
//        List<SubcategoryEntity> subcategoryEntities = subcategoryRepository.findAll();
//
//        try{
//            for(SubcategoryEntity subcategoryEntity : subcategoryEntities){
//                addSubcategoryEntityToCategoryEntity(subcategoryEntity, categoryEntity);
//            }
//        }catch (Exception e){
//            System.out.println("Subcategory could not be added to category " + categoryEntity.getIdString());
//        }
//    }
//
//    public List<CategoryDto> addAllSubcategoriesToAllCategories(){
//        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
//        List<CategoryDto> categoryDtos = new ArrayList<>();
//
//        for(CategoryEntity categoryEntity : categoryEntities){
//            addAllSubCategoriesToCategory(categoryEntity.getIdString());
//            categoryDtos.add(toCategoryDto(categoryEntity));
//        }
//
//        return categoryDtos;
//    }



}
