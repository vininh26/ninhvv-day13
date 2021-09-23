package com.example.ninhvvday13.api;

import com.example.ninhvvday13.entity.DepartmentEntity;
import com.example.ninhvvday13.entity.EmployeeEntity;
import com.example.ninhvvday13.model.DepartmenRes;
import com.example.ninhvvday13.model.DepartmentList;
import com.example.ninhvvday13.model.DepartmentReq;
import com.example.ninhvvday13.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    private DepartmentService service ;
    @Autowired
    public DepartmentController(DepartmentService service){
        this.service = service;
    }
    @RequestMapping(value = "/departments",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<DepartmentList> getAllDepartment(){
        DepartmentList res = service.getAllDepartment();
        return new ResponseEntity<>(res, HttpStatus.OK);

    }
    @PostMapping("/departmen")
    public DepartmentEntity add(@RequestBody DepartmentEntity department){
        return service.add(department);
    }
    @RequestMapping(value = "/department",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<DepartmenRes> addDepartment(@RequestBody DepartmentReq departmentReq){
        DepartmenRes departmenRes = service.addDepartment(departmentReq);
        return new ResponseEntity<>(departmenRes,HttpStatus.OK);
    }
}
