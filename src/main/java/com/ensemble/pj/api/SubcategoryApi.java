package com.ensemble.pj.api;

import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.SubcategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface SubcategoryApi {

    @RequestMapping(value = "/subcategory/{subcategoryName}", method = RequestMethod.GET)
    ResponseEntity<SubcategoryDto> getSubcategoryByName(@PathVariable("subcategoryName") String subcategoryName);

    @RequestMapping(value = "/subcategory/create",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<SubcategoryDto> createSubcategory(@RequestBody SubcategoryDto body);

    @RequestMapping(value = "/subcategory/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity<SubcategoryDto> deleteSubcategory(@PathVariable("id") String id);

    @RequestMapping(value = "/subcategory/find/{id}", method = RequestMethod.GET)
    ResponseEntity<SubcategoryDto> findSubcategoryById(@PathVariable("id") String id);

    @RequestMapping(value = "/subcategory/all", method = RequestMethod.GET)
    ResponseEntity<List<SubcategoryDto>> getAllSubcategories();

    @RequestMapping(value="/subcategory/map-category/{id}", method = RequestMethod.PUT)
    ResponseEntity<SubcategoryDto> mapCategoryToSubcategory(@PathVariable("id") String id,
                                                            @RequestBody CategoryDto body);

//    @RequestMapping(value="/subcategory/map-all-subcategories-to-category/{categoryId}", method = RequestMethod.PUT)
//    ResponseEntity<String> mapAllSubcategoriesToCategory(@PathVariable("categoryId") String categoryId);
//
//    @RequestMapping(value="/subcategory/map-all-subcategories-to-all-category", method = RequestMethod.PUT)
//    ResponseEntity<List<CategoryDto>> mapAllSubcategoriesToAllCategories();
}
