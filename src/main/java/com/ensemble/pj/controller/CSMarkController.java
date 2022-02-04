package com.ensemble.pj.controller;

import com.ensemble.pj.api.CSMarkApi;
import com.ensemble.pj.domain.CategorySubcategoryMarkEntity;
import com.ensemble.pj.dto.CSMDto;
import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.CategorySubcategoryMarkDto;
import com.ensemble.pj.service.CategorySubcategoryMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CSMarkController implements CSMarkApi {

    @Autowired
    CategorySubcategoryMarkService service;

    //Throws error: ava.sql.SQLIntegrityConstraintViolationException: Column 'category_entity_id' cannot be null
    @Override
    public ResponseEntity<CategorySubcategoryMarkDto> updateCategoryPercentage1(String cid, String sid, Double mark) {
        CategorySubcategoryMarkDto dto = service.mapCategoryAndSubcategoryAndMarkParam(cid,sid,mark);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategorySubcategoryMarkDto> updateCategoryPercentage(CSMDto body) {
        CategorySubcategoryMarkDto dto = service.mapCategoryAndSubcategoryAndMark(body);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategorySubcategoryMarkDto>> getAll() {
        List<CategorySubcategoryMarkDto> dtos = service.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
