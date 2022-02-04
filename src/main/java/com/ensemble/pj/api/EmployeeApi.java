package com.ensemble.pj.api;

import com.ensemble.pj.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface EmployeeApi {

    @RequestMapping(value = "/employee/{lastName}", method = RequestMethod.GET)
    ResponseEntity<EmployeeDto> getEmployeeByLastNAme(@PathVariable("lastName") String lastName);

    @RequestMapping(value = "/employee/create",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto body);

    @RequestMapping(value="/employee/delete", method = RequestMethod.DELETE)
    ResponseEntity<EmployeeDto> deleteEmployee(@RequestBody EmployeeDto body);

    @RequestMapping(value="/employee/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteEmployeeById(@PathVariable("id") String id);

    @RequestMapping(value="employee/find/{id}", method = RequestMethod.GET)
    ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable("id") String id);

    @RequestMapping(value="employee/all", method = RequestMethod.GET)
    ResponseEntity<List<EmployeeDto>> getAllEmployees();

    @RequestMapping(value = "/employee/map-all-categories/{id}", method = RequestMethod.PUT)
    ResponseEntity<EmployeeDto> mapAllCategoriesToEmployee(@PathVariable("id") String id);

    @RequestMapping(value = "/employee/map-all-categories-to-all-employees", method = RequestMethod.PUT)
    ResponseEntity<List<EmployeeDto>> mapAllCategoriesToAllEmployees();
}
