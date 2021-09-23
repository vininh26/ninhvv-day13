package com.example.ninhvvday13.api;

import com.example.ninhvvday13.entity.EmployeeEntity;
import com.example.ninhvvday13.model.EmployeeList;
import com.example.ninhvvday13.model.EmployeeReq;
import com.example.ninhvvday13.model.EmployeeRes;
import com.example.ninhvvday13.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @RequestMapping(value = "/department/employees",produces = {"application/json"},method = RequestMethod.GET)
    public ResponseEntity<EmployeeList> getAllEmployees(){
        EmployeeList response = employeeService.getAllEmployee();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/department/emplo")
    public EmployeeEntity add(@RequestBody EmployeeEntity employee){
        return employeeService.add(employee);
    }
    @RequestMapping(value = "/department/employee/addemployee",produces = {"application/json"},method = RequestMethod.POST)
    public ResponseEntity<EmployeeRes> addEmployee(@RequestBody EmployeeReq employeeReq){
        EmployeeRes response = employeeService.addEmployee(employeeReq);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
    @RequestMapping(value = "/department/employees/{id}",produces = {"application/json"},method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeRes> delEmployee(@PathVariable("id") String id){
       employeeService.removeEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/department/employees/{id}",produces = {"application/json"},method = RequestMethod.PATCH)
    public ResponseEntity<EmployeeRes> pathtodo(@PathVariable("id") String id,@RequestBody EmployeeReq employeeReq){
        employeeService.updateEmployee(id,employeeReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
