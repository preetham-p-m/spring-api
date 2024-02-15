package com.pmp.springapi.service.implementation;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.pmp.springapi.error.not_found.NotFoundException;
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
    public Department getDepartmentsId(@NonNull UUID id) throws NotFoundException {
        var department = this.departmentRepository.findById(id);

        if (!department.isPresent()) {
            throw new NotFoundException("Deparment not found");
        }

        return department.get();
    }

    @Override
    public Department getDepartmentByName(@NonNull String name) {
        return this.departmentRepository.findByName(name);
    }

    @Override
    public Department updateDepartment(@NonNull UUID id, Department newDepartment) throws NotFoundException {
        var optionaldDepartment = this.departmentRepository.findById(id);

        if (!optionaldDepartment.isPresent()) {
            throw new NotFoundException("Department not found");
        }

        var department = optionaldDepartment.get();

        if (Objects.nonNull(newDepartment.getName()) && !"".equalsIgnoreCase(newDepartment.getName())) {
            department.setName(newDepartment.getName());
        }

        if (Objects.nonNull(newDepartment.getAddress()) && !"".equalsIgnoreCase(newDepartment.getAddress())) {
            department.setAddress(newDepartment.getAddress());
        }

        if (Objects.nonNull(newDepartment.getCode())) {
            department.setCode(newDepartment.getCode());
        }

        return this.departmentRepository.save(department);
    }

    @Override
    public ResponseEntity<Object> deleteDepartment(@NonNull UUID id) {
        this.departmentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
