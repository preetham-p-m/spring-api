package com.pmp.springapi.service.implementation;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.pmp.springapi.model.Department;
import com.pmp.springapi.repository.interfaces.DepartmentRepository;
import com.pmp.springapi.service.interfaces.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(@NonNull Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentsId(@NonNull UUID id) {
        return this.departmentRepository.findById(id).get();
    }

    @Override
    public Department getDepartmentByName(@NonNull String name) {
        return this.departmentRepository.findByName(name);
    }

    @Override
    public Department updateDepartment(UUID id, Department department) {
        Department departmentDB = this.departmentRepository.findById(id).get();

        if (Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())) {
            departmentDB.setName(department.getName());
        }

        if (Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(department.getAddress())) {
            departmentDB.setAddress(department.getAddress());
        }

        if (Objects.nonNull(department.getCode())) {
            departmentDB.setCode(department.getCode());
        }

        return this.departmentRepository.save(departmentDB);
    }

    @Override
    public ResponseEntity<Object> deleteDepartment(@NonNull UUID id) {
        this.departmentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
