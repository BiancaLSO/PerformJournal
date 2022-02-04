package com.ensemble.pj.api;

import com.ensemble.pj.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ComputationApi {

    @RequestMapping(value = "/compute/category-mark/{categoryId}", method = RequestMethod.PUT)
    ResponseEntity<CategoryDto> computeMarkForCategory(@PathVariable("categoryId") String id);

    @RequestMapping(value = "/compute/weighted-avg", method = RequestMethod.PUT)
    ResponseEntity<Double> computeWeightedAverage();

    @RequestMapping(value = "/compute/category-marks-all", method = RequestMethod.PUT)
    ResponseEntity<List<CategoryDto>> computeMarks();


}
