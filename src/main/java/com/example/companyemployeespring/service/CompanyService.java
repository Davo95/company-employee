package com.example.companyemployeespring.service;

import com.example.companyemployeespring.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> companyFindAll();

    Company addCompany(Company company);

    void deleteCompany(int id);
}
