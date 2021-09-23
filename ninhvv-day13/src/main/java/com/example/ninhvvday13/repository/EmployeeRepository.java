package com.example.ninhvvday13.repository;

import com.example.ninhvvday13.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<EmployeeEntity,String> {
    @Override
    List<EmployeeEntity> findAll();
}
