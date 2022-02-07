package com.paytm.edmapplication;


import com.paytm.edmapplication.model.Department;
import com.paytm.edmapplication.model.Employee;
import com.paytm.edmapplication.repository.EmployeeRepository;
import com.paytm.edmapplication.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServicesTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    Employee emp1, emp2,emp3;
    List<Employee>employeeList;

    @BeforeEach
    public void setUp() {
        employeeList = new ArrayList<>();
        emp1 = new Employee(1,"Utkarsh", "Varanasi", new Department(1, "Paytm Bank", new ArrayList<>()));
        emp2 = new Employee(2,"Naman", "Delhi", new Department(2, "Paytm Mall", new ArrayList<>()));
        emp3 = new Employee(3,"Shubham", "Kanpur", new Department(3, "Paytm Gold", new ArrayList<>()));
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
    }

    @AfterEach
    public void tearDown() {
        emp1 = emp2 = emp3 = null;
        employeeList = null;
    }

    @Test
    public void getAllEmployeesTest(){

        when(this.employeeRepository.findAll()).thenReturn(employeeList);

        List<Employee> list = this.employeeService.getAllEmployees();

        assertEquals(3, list.size());
        verify(employeeRepository,times(1)).findAll();

    }

    @Test
    public void getEmployeeByIdTest(){

        when(employeeRepository.findById(1)).thenReturn(Optional.of(emp1));

        Employee employee = this.employeeService.getEmployeeById(1);
        assertEquals("Utkarsh", employee.getName());
        assertEquals("Varanasi", employee.getAddress());
        assertEquals("Paytm Bank", employee.getDepartment().getName());
    }

    @Test
    public void deleteEmployeeTest() throws Exception {

        Employee emp = new Employee();
        emp.setId(1);

        when(employeeRepository.findById(emp.getId())).thenReturn(Optional.of(emp));

        this.employeeService.deleteEmployee(emp.getId());
        verify(employeeRepository).deleteById(emp.getId());

    }


}
