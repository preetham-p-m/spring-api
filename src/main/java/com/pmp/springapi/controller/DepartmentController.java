package com.pmp.springapi.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmp.springapi.error.not_found.NotFoundException;
import com.pmp.springapi.model.Department;
import com.pmp.springapi.service.interfaces.DepartmentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/department")
@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping()
    public Department createDepartment(@Valid @RequestBody @NonNull Department department) {
        logger.debug("Create Department is called");
        return this.departmentService.createDepartment(department);
    }

    @GetMapping()
    public List<Department> getDepartments() {
        logger.info("Get Departments is called");
        return this.departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") @NonNull UUID id) throws NotFoundException {
        return this.departmentService.getDepartmentsId(id);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") @NonNull String name) {
        return this.departmentService.getDepartmentByName(name);
    }

    @PutMapping("/{id}")
    public Department putMethodName(@PathVariable("id") @NonNull UUID id, @RequestBody @NonNull Department department)
            throws NotFoundException {
        return this.departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable("id") @NonNull UUID id) {
        return this.departmentService.deleteDepartment(id);
    }
}
