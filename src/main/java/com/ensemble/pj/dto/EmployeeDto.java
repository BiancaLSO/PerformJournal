package com.ensemble.pj.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class EmployeeDto extends BaseDto {

    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private double markFinal;
    @Getter @Setter
    private List<CategoryDto> categories;


}
