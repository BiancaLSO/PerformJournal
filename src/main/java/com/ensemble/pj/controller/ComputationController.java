package com.ensemble.pj.controller;

import com.ensemble.pj.api.ComputationApi;
import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.service.ComputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComputationController implements ComputationApi {

    @Autowired
    ComputationService computationService;

    @Override
    public ResponseEntity<CategoryDto> computeMarkForCategory(String id) {
        CategoryDto categoryDto = computationService.computeMarkForCategory(id);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Double> computeWeightedAverage() {
        Double avg = computationService.categoryWeightedAverage();
        return new ResponseEntity<>(avg, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> computeMarks() {
        List<CategoryDto> categoryDtos = computationService.computeCategoryMarks();
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }
}
