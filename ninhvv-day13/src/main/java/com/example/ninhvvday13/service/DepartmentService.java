package com.example.ninhvvday13.service;

import com.example.ninhvvday13.entity.DepartmentEntity;
import com.example.ninhvvday13.entity.EmployeeEntity;
import com.example.ninhvvday13.mapper.DepartmentMapper;
import com.example.ninhvvday13.model.DepartmenRes;
import com.example.ninhvvday13.model.DepartmentList;
import com.example.ninhvvday13.model.DepartmentReq;
import com.example.ninhvvday13.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private  final DepartmentMapper mapper;
    private  final DepartmentRepository repository;

    public DepartmentService(DepartmentMapper mapper , DepartmentRepository repository){
        this.mapper = mapper;
        this.repository = repository ;
    }
    public DepartmenRes addDepartment(DepartmentReq departmentReq){
        DepartmentEntity entity = mapper.mapDepaermentFromReq(departmentReq);
        DepartmentEntity saved = repository.save(entity);
        return mapper.mapDepartmentFromEntity(saved);
    }
    public DepartmentEntity add(DepartmentEntity department){
        return repository.save(department);
    }
    public DepartmenRes updateDepartment(String id, DepartmentReq departmentReq){
        DepartmentEntity entity = mapper.mapDepaermentFromReq(id,departmentReq);
        DepartmentEntity saved = repository.save(entity);
        return mapper.mapDepartmentFromEntity(saved);
    }
    public DepartmentList getAllDepartment(){
        DepartmentList ls = mapper.mapDepartmentFromEntities(repository.findAll());
        return ls;
    }
    public  void removeDepartment(String departmentId){
        DepartmentEntity entity = repository.getOne(departmentId);
        repository.delete(entity);
    }
}
