package com.example.ninhvvday13.mapper;

import com.example.ninhvvday13.entity.DepartmentEntity;
import com.example.ninhvvday13.model.DepartmenRes;
import com.example.ninhvvday13.model.DepartmentList;
import com.example.ninhvvday13.model.DepartmentReq;
import com.example.ninhvvday13.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentMapper {
    private final DepartmentRepository repository ;
    @Autowired
    public DepartmentMapper(DepartmentRepository repository){
        this.repository =repository;
    }
    public DepartmenRes mapDepartmentFromEntity(DepartmentEntity from){
        DepartmenRes to = new DepartmenRes();
        to.setId(from.getId());
        to.setLocation(from.getLocation());
        to.setFieldOperations(from.getFieldOperations());
        to.setTotalEmployee(from.getTotalEmployee());
        return to;
    }
    public DepartmentList mapDepartmentFromEntities(List<DepartmentEntity> from){
        DepartmentList to = new DepartmentList();
        from.stream().forEach(too -> {
            to.add(mapDepartmentFromEntity(too));
        });
        return to;
    }
    public DepartmentEntity mapDepaermentFromReq(DepartmentReq from) {
        DepartmentEntity to = new DepartmentEntity();
        to.setId(Integer.parseInt(UUID.randomUUID().toString()));
        to.setLocation(from.getLocation());
        to.setFieldOperations(from.getFieldOperations());
        to.setTotalEmployee(from.getTotalEmployee());
        return  to;
    }
    public DepartmentEntity mapDepaermentFromReq(String id,DepartmentReq from){
        DepartmentEntity to = repository.getOne(id);
        to.setFieldOperations(from.getFieldOperations());
        return to;
    }
}
