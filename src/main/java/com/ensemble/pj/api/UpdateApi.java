package com.ensemble.pj.api;

import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UpdateApi {

    @RequestMapping(value = "update/employee-form", method = RequestMethod.PUT)
    ResponseEntity<EmployeeDto> createCategory(@RequestBody EmployeeDto body);
}
