package com.testing_void;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeClassTest {

    @Test
    void setting_null_to_verify_throws_exception() throws IllegalArgumentException {
        EmployeeClass employee = mock(EmployeeClass.class);
        doThrow(IllegalArgumentException.class).when(employee).setName(null);
        assertThrows(IllegalArgumentException.class, () -> employee.setName(null));
    }

    @Test
    void setting_valid_string_employee_name() {
        EmployeeClass employeeClass = mock(EmployeeClass.class);
        doAnswer((ans) -> {
            assertEquals("test", ans.getArgument(0));
            return null;
        }).when(employeeClass).setName(anyString());
        when(employeeClass.getName()).thenReturn("test");

        assertEquals("test", employeeClass.getName());
    }

    @Test
    void print_employee_object(){
        EmployeeClass employeeClass = mock(EmployeeClass.class);
        when(employeeClass.toString()).thenReturn(null);
        when(employeeClass.getGender()).thenReturn("Male");
        when(employeeClass.getName()).thenReturn("jhon");

        System.out.println(employeeClass.getGender());
        System.out.println(employeeClass.getName());
        System.out.println(employeeClass);
    }
}