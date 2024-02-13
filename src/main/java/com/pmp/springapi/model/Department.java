package com.pmp.springapi.model;

import java.util.UUID;

import com.pmp.springapi.enums.DepartmentCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    private String address;

    private DepartmentCode code;

    public Department() {
    }

    public Department(String name, String address, DepartmentCode code) {
        this.name = name;
        this.address = address;
        this.code = code;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DepartmentCode getCode() {
        return this.code;
    }

    public void setCode(DepartmentCode code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Department [id=" + this.id + ", name=" + this.name + ", address=" + this.address + ", code=" + this.code
                + "]";
    }

}
