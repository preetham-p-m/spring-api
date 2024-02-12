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

    @GetMapping()
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("{id}")
    public Department getDepartmentById(@PathVariable("id") @NonNull UUID id) {
        return departmentService.getDepartmentsId(id);
    }

    @PostMapping()
    public Department createDepartment(@RequestBody @NonNull Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("{id}")
    public Department putMethodName(@PathVariable("id") @NonNull UUID id, @RequestBody @NonNull Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable("id") @NonNull UUID id) {
        return departmentService.deleteDepartment(id);
    }
}
