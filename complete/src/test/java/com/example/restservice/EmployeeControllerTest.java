/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeManager employeeManager;

    @Before
    public void setup() {
        // You can perform setup tasks here if needed.
    }

    @Test
    public void testAddEmployee() {
        // Create a mock employee to add
        Employee mockEmployee = new Employee();
        mockEmployee.setEmployee_id("1");
        mockEmployee.setFirst_name("John");
        mockEmployee.setLast_name("Doe");
        mockEmployee.setEmail("john@example.com");
        mockEmployee.setTitle("Manager");

        // Define the behavior of the employeeManager mock
        Mockito.when(employeeManager.addEmployee(Mockito.any(Employee.class))).thenReturn(mockEmployee);

        // Perform the test
        Employee addedEmployee = employeeController.addEmployee(mockEmployee);

        // Verify that the employee was added correctly
        assertEquals(mockEmployee.getEmployee_id(), addedEmployee.getEmployee_id());
        assertEquals(mockEmployee.getFirst_name(), addedEmployee.getFirst_name());
        assertEquals(mockEmployee.getLast_name(), addedEmployee.getLast_name());
        assertEquals(mockEmployee.getEmail(), addedEmployee.getEmail());
        assertEquals(mockEmployee.getTitle(), addedEmployee.getTitle());
    }

    // You can add more test methods for other scenarios and behaviors.
}
