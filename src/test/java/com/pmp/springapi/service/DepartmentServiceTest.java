package com.pmp.springapi.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pmp.springapi.enums.DepartmentCode;
import com.pmp.springapi.model.Department;
import com.pmp.springapi.repository.interfaces.DepartmentRepository;
import com.pmp.springapi.service.interfaces.DepartmentService;

class DepartmentServiceTest {

    @Nested
    @SpringBootTest
    class GetDepartmentByName {

        @Autowired
        private DepartmentService departmentService;

        @MockBean
        private DepartmentRepository departmentRepository;

        private Department department;

        @BeforeEach
        void setUp() {
            this.department = Department.builder().name("IT").code(DepartmentCode.E001).build();
            Mockito.when(this.departmentRepository.findByName("IT")).thenReturn(department);
        }

        @Test
        @DisplayName("Should return department when name is present")
        void Should_Return_Department() {
            Department department = departmentService.getDepartmentByName("IT");

            assertThat(department).isEqualTo(this.department);
        }

        @Test
        @DisplayName("Should return null when name is present")
        void Should_Return_Null() {
            Department department = departmentService.getDepartmentByName("BT");

            assertThat(department).isNull();
        }
    }
}
