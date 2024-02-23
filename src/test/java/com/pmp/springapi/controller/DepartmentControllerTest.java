package com.pmp.springapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pmp.springapi.enums.DepartmentCode;
import com.pmp.springapi.model.Department;
import com.pmp.springapi.service.interfaces.DepartmentService;

class DepartmentControllerTest {

    @Nested
    @WebMvcTest(DepartmentController.class)
    class SaveDepartment {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private DepartmentService departmentService;

        private Department department;

        @BeforeEach
        void setup() {
            this.department = Department.builder().address("test address").code(DepartmentCode.E002).name("test")
                    .build();
        }

        @Test
        void Should_Save_Department() throws Exception {
            Mockito.when(this.departmentService.createDepartment(this.department)).thenReturn(this.department);

            this.mockMvc
                    .perform(post("/department").contentType(MediaType.APPLICATION_JSON)
                            .content("{\"name\":\"test\",\"address\":\"test address\",\"code\":\"E002\"}"))
                    .andExpect(status().isOk());
        }
    }

}
