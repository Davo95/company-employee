package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.model.Company;
import com.example.companyemployeespring.model.Employee;
import com.example.companyemployeespring.service.CompanyService;
import com.example.companyemployeespring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/employees")
    public String company(ModelMap modelMap) {
        List<Employee> employees = employeeService.employeeFindAll();
        modelMap.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/employees/add")
    public String employeeAdd(ModelMap modelMap) {
        List<Company> companys = companyService.companyFindAll();
        modelMap.addAttribute("companys",companys);
        return "addEmployees";
    }

    @PostMapping("/employees/add")
    public String employeeAddPost(@ModelAttribute Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String employeeDelete(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
