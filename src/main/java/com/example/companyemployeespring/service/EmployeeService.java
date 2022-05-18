package com.example.companyemployeespring.service;

import com.example.companyemployeespring.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> employeeFindAll();

    void addEmployee(Employee employee);

    void deleteEmployee(int id);
}
