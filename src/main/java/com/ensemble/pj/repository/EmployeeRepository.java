package com.ensemble.pj.repository;

import com.ensemble.pj.domain.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    EmployeeEntity findByLastName(String lastName);
    EmployeeEntity findById(UUID uuid);
    void deleteById(UUID uuid);
}
