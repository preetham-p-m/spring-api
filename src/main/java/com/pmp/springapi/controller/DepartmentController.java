package com.pmp.springapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmp.springapi.model.Department;
import com.pmp.springapi.service.interfaces.DepartmentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/department")
@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping()
    public Department createDepartment(@RequestBody @NonNull Department department) {
        return this.departmentService.createDepartment(department);
    }

    @GetMapping()
    public List<Department> getDepartments() {
        return this.departmentService.getDepartments();
    }

    @GetMapping("{id}")
    public Department getDepartmentById(@PathVariable("id") @NonNull UUID id) {
        return this.departmentService.getDepartmentsId(id);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") @NonNull String name) {
        return this.departmentService.getDepartmentByName(name);
    }

    @PutMapping("{id}")
    public Department putMethodName(@PathVariable("id") @NonNull UUID id, @RequestBody @NonNull Department department) {
        return this.departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable("id") @NonNull UUID id) {
        return this.departmentService.deleteDepartment(id);
    }
}
