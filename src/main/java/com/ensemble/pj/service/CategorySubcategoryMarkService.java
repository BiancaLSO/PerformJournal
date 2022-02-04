package com.ensemble.pj.service;

import com.ensemble.pj.domain.CategoryEntity;
import com.ensemble.pj.domain.CategorySubcategoryEntiity;
import com.ensemble.pj.domain.CategorySubcategoryMarkEntity;
import com.ensemble.pj.domain.SubcategoryEntity;
import com.ensemble.pj.dto.*;
import com.ensemble.pj.repository.CategoryRepository;
import com.ensemble.pj.repository.CategorySubcategoryMarkRepository;
import com.ensemble.pj.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.ensemble.pj.domain.CategorySubcategoryMarkEntity.toDto;
import static com.ensemble.pj.domain.SubcategoryEntity.toSubcategoryDto;
import static com.ensemble.pj.domain.CategoryEntity.toCategoryDto;

@Service
public class CategorySubcategoryMarkService {

    @Autowired
    private CategorySubcategoryMarkRepository repo;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubcategoryRepository subcategoryRepository;
    @Autowired
    private SubcategoryService subcategoryService;

    public CategorySubcategoryMarkDto mapCategoryAndSubcategoryAndMarkParam(String categoryId,
                                                                       String subcategoryID,
                                                                       Double mark){

        CategoryEntity categoryEntity = categoryRepository.findById(UUID.fromString(categoryId));
        SubcategoryEntity subcategoryEntity = subcategoryRepository.findById(UUID.fromString(subcategoryID));

        CategorySubcategoryMarkEntity categorySubcategoryMarkEntity = new CategorySubcategoryMarkEntity();
        categorySubcategoryMarkEntity.setCategoryEntity(categoryEntity);
        categorySubcategoryMarkEntity.setSubcategoryEntity(subcategoryEntity);
        categorySubcategoryMarkEntity.setMark(mark);

        repo.save(categorySubcategoryMarkEntity);

        return toDto(categorySubcategoryMarkEntity);
    }


    public CategorySubcategoryMarkDto mapCategoryAndSubcategoryAndMark(CSMDto body) {
        CategoryEntity categoryEntity = categoryRepository.findById(UUID.fromString(body.getCategoryId()));
        SubcategoryEntity subcategoryEntity = subcategoryRepository.findById(UUID.fromString(body.getSubcategoryId()));

        CategorySubcategoryMarkEntity categorySubcategoryMarkEntity = new CategorySubcategoryMarkEntity(categoryEntity,
                subcategoryEntity, body.getMark());

        repo.save(categorySubcategoryMarkEntity);

        return toDto(categorySubcategoryMarkEntity);
    }

    public List<CategorySubcategoryMarkDto> getAll(){
        List<CategorySubcategoryMarkEntity> records = repo.findAll();
        return records.stream().map(CategorySubcategoryMarkEntity::toDto).collect(Collectors.toList());
    }

    public CategorySubcategoryMarkEntity findById(CategoryEntity categoryEntity, SubcategoryEntity subcategoryEntity){
        CategorySubcategoryEntiity categorySubcategoryEntiity =
                new CategorySubcategoryEntiity(categoryEntity.getId(), subcategoryEntity.getId());
        CategorySubcategoryMarkEntity record = repo.findById(categorySubcategoryEntiity);

        return record;
    }


    public CategorySubcategoryMarkDto updateCategorySubcategoryMark(CategoryDto categoryDto, SubcategoryDto subcategoryDto,
                                                                    Double mark){

        CategorySubcategoryMarkEntity record = repo.findByCategoryEntityIdAndSubcategoryEntityId(UUID.fromString(categoryDto.getId()),
                UUID.fromString(subcategoryDto.getId()));

        record.setMark(mark);
        repo.save(record);

        return toDto(record);
    }
}
