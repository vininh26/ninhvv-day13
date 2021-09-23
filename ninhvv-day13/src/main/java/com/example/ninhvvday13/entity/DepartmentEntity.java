package com.example.ninhvvday13.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class DepartmentEntity {
    @Id
    @Column(name = "id_department")
    private int id;
    @Column(name = "name_department")
    private int totalEmployee;
    private String location;
    private String fieldOperations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalEmployee() {
        return totalEmployee;
    }

    public void setTotalEmployee(int totalEmployee) {
        this.totalEmployee = totalEmployee;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFieldOperations() {
        return fieldOperations;
    }

    public void setFieldOperations(String fieldOperations) {
        this.fieldOperations = fieldOperations;
    }
}
