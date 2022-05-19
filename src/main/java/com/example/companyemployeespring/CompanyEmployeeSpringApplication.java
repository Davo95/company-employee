package com.example.companyemployeespring;

import com.example.companyemployeespring.model.Company;
import com.example.companyemployeespring.model.Employee;
import com.example.companyemployeespring.model.Position;
import com.example.companyemployeespring.model.RoleEmployee;
import com.example.companyemployeespring.repository.CompanyRepository;
import com.example.companyemployeespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CompanyEmployeeSpringApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(CompanyEmployeeSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (employeeRepository.findByEmail("admin@mail.com").isEmpty()) {
            Company company = companyRepository.save(Company.builder()
                    .name("IT")
                    .size(53)
                    .address("Gyumri")
                    .build());


            employeeRepository.save(Employee.builder()
                    .name("admin")
                    .surname("admin")
                    .phoneNumber("123456")
                    .salary(5624)
                    .email("admin@mail.com")
                    .password(passwordEncoder.encode("admin"))
                    .roleEmployee(RoleEmployee.ADMIN)
                    .position(Position.JUNIOR)
                    .company(company)
                    .build());
        }
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
