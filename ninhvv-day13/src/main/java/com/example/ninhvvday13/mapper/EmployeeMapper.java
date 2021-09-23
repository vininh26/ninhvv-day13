package com.example.ninhvvday13.mapper;

import com.example.ninhvvday13.entity.EmployeeEntity;
import com.example.ninhvvday13.model.EmployeeList;
import com.example.ninhvvday13.model.EmployeeRes;
import com.example.ninhvvday13.model.EmployeeReq;
import com.example.ninhvvday13.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeMapper {
    private final EmployeeRepository employ;
    @Autowired
    public EmployeeMapper(EmployeeRepository employ){
        this.employ = employ ;
    }
    public EmployeeRes mapEmployeeFromEmployEntity(EmployeeEntity from){
        EmployeeRes to = new EmployeeRes();

        to.setId(Integer.parseInt(String.valueOf(from.getId())));
        to.setName(from.getName());
        to.setAge(from.getAge());
        to.setAddres(from.getAddres());
        to.setPosition(from.getPosition());
        to.setDepartmentId(from.getDepartmentId());

        return  to;
    }
    public EmployeeList mapEmployeeFromEmployeeEntities(List<EmployeeEntity> from){
        EmployeeList to = new EmployeeList();
        from.stream().forEach(employee -> {
            to.add(mapEmployeeFromEmployEntity(employee));
        });
        return to;
    }
    public EmployeeEntity mapEmployeeEntityFromEmtityReq(EmployeeReq from){
        EmployeeEntity to = new EmployeeEntity();
        to.setId(Integer.parseInt(UUID.randomUUID().toString()));
        to.setName(from.getName());
        to.setAge(from.getAge());
        to.setAddres(from.getAddres());
        to.setPosition(from.getPosition());
        to.setDepartmentId(from.getDepartmentId());
        return to;
    }

    public EmployeeEntity mapEmployeeEntityFromEmtityReq(String id, EmployeeReq employeeReq) {
        EmployeeEntity to = employ.getOne(id);
        to.setId(Integer.parseInt(employeeReq.getName()));
        return  to;
    }
}
