package com.ensemble.pj.controller;

import com.ensemble.pj.api.UpdateApi;
import com.ensemble.pj.dto.EmployeeDto;
import com.ensemble.pj.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController implements UpdateApi {

    @Autowired
    UpdateService updateService;

    @Override
    public ResponseEntity<EmployeeDto> createCategory(EmployeeDto body) {
        EmployeeDto employeeDto = updateService.updateFromBody(body);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
