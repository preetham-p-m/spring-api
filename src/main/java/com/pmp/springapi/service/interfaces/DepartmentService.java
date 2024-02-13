package com.pmp.springapi.service.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;

import com.pmp.springapi.model.Department;

public interface DepartmentService {

    Department createDepartment(@NonNull Department department);

    List<Department> getDepartments();

    Department getDepartmentsId(@NonNull UUID i);

    Department getDepartmentByName(@NonNull String name);

    Department updateDepartment(UUID id, Department department);

    ResponseEntity<Object> deleteDepartment(@NonNull UUID id);
}
