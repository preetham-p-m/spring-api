package com.pmp.springapi.service.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;

import com.pmp.springapi.error.not_found.NotFoundException;
import com.pmp.springapi.model.Department;

public interface DepartmentService {

    Department createDepartment(@NonNull Department department);

    List<Department> getDepartments();

    Department getDepartmentsId(@NonNull UUID i) throws NotFoundException;

    Department getDepartmentByName(@NonNull String name);

    Department updateDepartment(@NonNull UUID id, Department department) throws NotFoundException;

    ResponseEntity<Object> deleteDepartment(@NonNull UUID id);
}
