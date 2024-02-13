package com.pmp.springapi.repository.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmp.springapi.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {

    public Department findByName(String name);
}
