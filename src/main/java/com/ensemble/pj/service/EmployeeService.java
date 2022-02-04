package com.ensemble.pj.service;

import com.ensemble.pj.domain.CategoryEntity;
import com.ensemble.pj.domain.EmployeeEntity;
import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.EmployeeDto;
import com.ensemble.pj.repository.CategoryRepository;
import com.ensemble.pj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.ensemble.pj.domain.EmployeeEntity.toEmployeeDto;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public boolean checkRepo(){
        return !categoryRepository.findAll().isEmpty();
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        if(checkRepo()){
            employeeEntity.setCategories(categoryEntities);
        }
        
        employeeEntity.setFirstName(employeeDto.getFirstName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeEntity.setMarkFinal(employeeDto.getMarkFinal());

        employeeRepository.saveAndFlush(employeeEntity);

        return toEmployeeDto(employeeEntity);
    }

    public EmployeeDto findEmployeeById(String id){
        UUID uuid = UUID.fromString(id);
        EmployeeEntity employeeEntity = employeeRepository.findById(uuid);
        return toEmployeeDto(employeeEntity);
    }

    public EmployeeEntity findEmployeeEntityById(String id){
        return employeeRepository.findById(UUID.fromString(id));
    }

    public EmployeeDto findEmployeeByLastName(String lastName){
        EmployeeEntity employeeEntity = employeeRepository.findByLastName(lastName);
        return toEmployeeDto(employeeEntity);
    }

    public void deleteEmployee(EmployeeDto employeeDto){
        UUID uuid = UUID.fromString(employeeDto.getId());
        employeeRepository.deleteById(uuid);
    }

    public void deleteEmployeeById(String id){
        employeeRepository.deleteById(UUID.fromString(id));
    }

    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeDto> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeEntities){
            employees.add(toEmployeeDto(employeeEntity));
        }
        return employees;
    }


    public EmployeeDto mapAllCategoriesToEmployee(String employeeId){
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        UUID employeeUUID = UUID.fromString(employeeId);
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeUUID);

        employeeEntity.setCategories(categoryEntities);
        employeeRepository.save(employeeEntity);

        return toEmployeeDto(employeeEntity);
    }

    public List<EmployeeDto> mapAllCategoriesToAllEmployees(){
       List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
       List<EmployeeDto> employeeDtos = new ArrayList<>();

       for(EmployeeEntity employeeEntity : employeeEntities){
           mapAllCategoriesToEmployee(employeeEntity.getIdString());
           employeeDtos.add(toEmployeeDto(employeeEntity));
       }

        return employeeDtos;
    }

    public EmployeeDto updateEmployeeCategories(EmployeeDto body, List<CategoryDto> categoryDtos ){
        EmployeeEntity employeeEntity = employeeRepository.findById(UUID.fromString(body.getId()));
        List<CategoryEntity> categoryEntities = new ArrayList<>();

        for(CategoryDto categoryDto : categoryDtos){
            CategoryEntity categoryEntity = categoryRepository.findById(UUID.fromString(categoryDto.getId()));
            categoryEntity.setMarkCategory(categoryDto.getMarkCategory());
            categoryRepository.save(categoryEntity);
            categoryEntities.add(categoryEntity);
        }

        employeeEntity.setMarkFinal(body.getMarkFinal());
        employeeRepository.save(employeeEntity);

        return toEmployeeDto(employeeEntity);
    }
}
