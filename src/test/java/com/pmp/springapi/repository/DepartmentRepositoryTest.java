package com.pmp.springapi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.pmp.springapi.enums.DepartmentCode;
import com.pmp.springapi.model.Department;
import com.pmp.springapi.repository.interfaces.DepartmentRepository;

class DepartmentRepositoryTest {

    @Nested
    @DataJpaTest
    class FindById {

        private Department mockedDepartment;

        @Autowired
        private DepartmentRepository departmentRepository;

        @Autowired
        private TestEntityManager entityManager;

        @BeforeEach
        void setUp() {
            this.mockedDepartment = Department.builder()
                    .name("Department1")
                    .code(DepartmentCode.E001)
                    .address("Delhi").build();

            entityManager.persist(mockedDepartment);
        }

        @Test
        void Should_Return_Department() {
            var department = departmentRepository.findById(this.mockedDepartment.getId()).get();

            assertThat(department.getCode()).isEqualTo(this.mockedDepartment.getCode());
            assertThat(department.getAddress()).isEqualTo(this.mockedDepartment.getAddress());
        }

    }
}
