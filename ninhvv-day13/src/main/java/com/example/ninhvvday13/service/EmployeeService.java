package com.example.ninhvvday13.service;

import com.example.ninhvvday13.entity.EmployeeEntity;
import com.example.ninhvvday13.mapper.EmployeeMapper;
import com.example.ninhvvday13.model.EmployeeList;
import com.example.ninhvvday13.model.EmployeeReq;
import com.example.ninhvvday13.model.EmployeeRes;
import com.example.ninhvvday13.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }
    public EmployeeRes addEmployee(EmployeeReq employeeReq){
        EmployeeEntity entity = employeeMapper.mapEmployeeEntityFromEmtityReq(employeeReq);
        EmployeeEntity saved = employeeRepository.save(entity);
        return employeeMapper.mapEmployeeFromEmployEntity(saved);
    }
    public EmployeeEntity add(EmployeeEntity employee){
        return employeeRepository.save(employee);
    }
    public EmployeeRes updateEmployee(String id , EmployeeReq employeeReq){
        EmployeeEntity entity = employeeMapper.mapEmployeeEntityFromEmtityReq(id, employeeReq);
        EmployeeEntity save = employeeRepository.save(entity);
        return employeeMapper.mapEmployeeFromEmployEntity(save);
    }
    public EmployeeList getAllEmployee(){
        EmployeeList list = employeeMapper.mapEmployeeFromEmployeeEntities(employeeRepository.findAll());
        return list;
    }
    public void removeEmployee(String id_employee){
        EmployeeEntity entity = employeeRepository.getOne(id_employee);
        employeeRepository.delete(entity);
    }


}
