package com.ensemble.pj.service;

import com.ensemble.pj.domain.CategoryEntity;
import com.ensemble.pj.domain.SubcategoryEntity;
import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.SubcategoryDto;
import com.ensemble.pj.repository.CategoryRepository;
import com.ensemble.pj.repository.SubcategoryRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.ensemble.pj.domain.CategoryEntity.toCategoryDto;
import static com.ensemble.pj.domain.SubcategoryEntity.toSubcategoryDto;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubcategoryRepository subcategoryRepository;


    public CategoryDto createCategory(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategoryName(categoryDto.getCategoryName());
        categoryEntity.setCategoryPercentage(categoryDto.getCategoryPercentage());
        categoryEntity.setMarkCategory(categoryDto.getMarkCategory());

        categoryRepository.saveAndFlush(categoryEntity);

        return toCategoryDto(categoryEntity);
    }

    public CategoryDto findCategoryById(String id) {
        CategoryEntity categoryEntity = categoryRepository.findById(UUID.fromString(id));
        return toCategoryDto(categoryEntity);
    }

    public CategoryEntity findCategoryEntity(String id){
        return categoryRepository.findById(UUID.fromString(id));
    }

    public CategoryDto findCategoryByName(String categoryName) {
        CategoryEntity categoryEntity = categoryRepository.findByCategoryName(categoryName);
        return toCategoryDto(categoryEntity);
    }

    public void deleteCategory(CategoryDto categoryDto) {
        categoryRepository.deleteById(UUID.fromString(categoryDto.getId()));
    }

    public CategoryDto updateCategoryMark(CategoryDto categoryDto,Double mark){
        CategoryEntity categoryEntity = categoryRepository.findById(UUID.fromString(categoryDto.getId()));
        categoryEntity.setMarkCategory(mark);
        categoryRepository.save(categoryEntity);

        return toCategoryDto(categoryEntity);
    }

    public void deleteCategoryById(String id){
        categoryRepository.deleteById(UUID.fromString(id));
    }

    public List<CategoryDto> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<CategoryDto> categories = new ArrayList<>();

        for (CategoryEntity categoryEntity : categoryEntities)  {
            categories.add(toCategoryDto(categoryEntity));
        }
        return categories;
    }


}
