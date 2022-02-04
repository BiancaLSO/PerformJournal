package com.ensemble.pj.api;

import com.ensemble.pj.dto.CSMDto;
import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.CategorySubcategoryMarkDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface CSMarkApi {

    @RequestMapping(value = "/csmark/map-category-subcategory-mark/{cid}/{sid}/{mark}", method = RequestMethod.PUT)
    ResponseEntity<CategorySubcategoryMarkDto> updateCategoryPercentage1(@PathVariable("cid") String cid,
                                                                        @PathVariable("sid") String sid,
                                                                        @PathVariable("mark") Double mark);

    @RequestMapping(value = "/csmark/map-category-subcategory-mark", method = RequestMethod.PUT)
    ResponseEntity<CategorySubcategoryMarkDto> updateCategoryPercentage(@RequestBody CSMDto body);

    @RequestMapping(value = "/csmark/all", method = RequestMethod.GET)
    ResponseEntity<List<CategorySubcategoryMarkDto>> getAll();
}
