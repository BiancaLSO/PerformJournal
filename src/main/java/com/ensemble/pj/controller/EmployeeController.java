package com.ensemble.pj.controller;

import com.ensemble.pj.api.EmployeeApi;
import com.ensemble.pj.domain.EmployeeEntity;
import com.ensemble.pj.dto.EmployeeDto;
import com.ensemble.pj.repository.EmployeeRepository;
import com.ensemble.pj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EmployeeController implements EmployeeApi {

    @Autowired
    EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeDto> getEmployeeByLastNAme(String lastName) {
        EmployeeDto employee = employeeService.findEmployeeByLastName(lastName);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeDto> createEmployee(EmployeeDto body) {
        EmployeeDto employee = employeeService.createEmployee(body);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<EmployeeDto> deleteEmployee(EmployeeDto body) {
        employeeService.deleteEmployee(body);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteEmployeeById(String id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Delete item with id " + id, HttpStatus.OK );
    }

    @Override
    public ResponseEntity<EmployeeDto> findEmployeeById(String id) {
        EmployeeDto employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeDto> mapAllCategoriesToEmployee(String id) {
        EmployeeDto employee = employeeService.mapAllCategoriesToEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmployeeDto>> mapAllCategoriesToAllEmployees() {
        List<EmployeeDto> employees = employeeService.mapAllCategoriesToAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
