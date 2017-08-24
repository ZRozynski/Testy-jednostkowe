package Interfaces;

import Classes.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> findAll();
}
