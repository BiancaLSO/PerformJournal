package com.ensemble.pj.api;

import com.ensemble.pj.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface CategoryApi {

    @RequestMapping(value = "/category/{categoryName}", method = RequestMethod.GET)
    ResponseEntity<CategoryDto> getCategoryByName(@PathVariable("categoryName") String categoryName);

    @RequestMapping(value = "category/create",
            produces = { "application/json"},
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto body);

    @RequestMapping(value = "/category/delete", method = RequestMethod.DELETE)
    ResponseEntity<CategoryDto> deleteCategory(@RequestBody CategoryDto body);

    @RequestMapping(value = "/category/find/{id}", method = RequestMethod.GET)
    ResponseEntity<CategoryDto> findCategoryById(@PathVariable("id") String id);

    @RequestMapping(value="/category/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteCategoryById(@PathVariable("id") String id);

    @RequestMapping(value = "/category/all", method = RequestMethod.GET)
    ResponseEntity<List<CategoryDto>> getAllCategories();

//    @RequestMapping(value = "/category/update-percentage/{id}/{value}", method = RequestMethod.PUT)
//    ResponseEntity<CategoryDto> updateCategoryPercentage(@PathVariable("id") String id,
//                                                         @PathVariable("value") Double value);

//    @RequestMapping(value="/category/map-all-subcategories-to-category/{categoryId}", method = RequestMethod.PUT)
//    ResponseEntity<CategoryDto> mapAllSubcategoriesToCategory(@PathVariable("categoryId") String categoryId);
//
//    @RequestMapping(value="/category/map-all-subcategories-to-all-category", method = RequestMethod.PUT)
//    ResponseEntity<List<CategoryDto>> mapAllSubcategoriesToAllCategories();

}
