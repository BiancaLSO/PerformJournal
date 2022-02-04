package com.ensemble.pj.domain;


import com.ensemble.pj.dto.CategoryDto;
import com.ensemble.pj.dto.EmployeeDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.ensemble.pj.domain.CategoryEntity.toCategoryDto;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity{

    private String firstName;
    private String lastName;
    private double markFinal;

    // Many to many between Employee and Category
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="employee_category",
            joinColumns = { @JoinColumn(name="id_employee") },
            inverseJoinColumns = { @JoinColumn(name="id_category") }
    )
    public List<CategoryEntity> categories;

    // Constructors
    public EmployeeEntity(String firstName, String lastName, double markFinal) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.markFinal = markFinal;
    }

    public EmployeeEntity() {}

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getMarkFinal() { return markFinal; }
    public void setMarkFinal(double markFinal) { this.markFinal = markFinal; }

    public List<CategoryEntity> getCategories() {
        return categories;
    }
    public void setCategories(List<CategoryEntity> categories) {
        if (this.categories == null){
            this.categories = new ArrayList<>();
        }
        this.categories = categories;
    }

    //to DTO

    public static List<CategoryDto> getCategoriesDto(EmployeeEntity employeeEntity){
        List<CategoryEntity> categoryEntities = employeeEntity.getCategories();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        for(CategoryEntity categoryEntity : categoryEntities){
            categoryDtos.add(toCategoryDto(categoryEntity));
        }

        return categoryDtos;
    }

    public static EmployeeDto toEmployeeDto(EmployeeEntity employeeEntity){
        if(employeeEntity == null)
            return null;

        EmployeeDto employee = new EmployeeDto();

        employee.setId(employeeEntity.getIdString());
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setMarkFinal(employeeEntity.getMarkFinal());
        employee.setCreatedAt(employeeEntity.formattedCreatedAt());
        employee.setModifiedAt(employeeEntity.formattedModifiedAt());

        if(employeeEntity.getCategories() != null){
            employee.setCategories(getCategoriesDto(employeeEntity));
        }

        return employee;
    }
}
