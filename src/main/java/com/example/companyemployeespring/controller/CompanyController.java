package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.model.Company;
import com.example.companyemployeespring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/companys")
    public String company(ModelMap modelMap) {
        List<Company> companys = companyService.companyFindAll();
        modelMap.addAttribute("companys", companys);
        return "companys";
    }

    @GetMapping("/companys/add")
    public String companyAdd() {
        return "addCompanys";
    }

    @PostMapping("/companys/add")
    public String companyAddPost(@ModelAttribute Company company) {
        companyService.addCompany(company);
        return "redirect:/companys";
    }

    @GetMapping("/companys/{id}")
    public String companyDelete(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
        return "redirect:/companys";
    }
}
