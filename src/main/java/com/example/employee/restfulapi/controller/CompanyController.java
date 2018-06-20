package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    @RequestMapping(method = RequestMethod.GET)
    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Company getCompany(@PathVariable("id") long id){
        return companyRepository.findOne(id);
    }
    @RequestMapping(value = "page/{pageNum}/pageSize/{pagesize}",method=RequestMethod.GET)
    public Page<Company> getPagebyCompany(@PathVariable("pageNum") int pageNum, @PathVariable("pagesize") int pagesize){
        Pageable pageable=new PageRequest(pageNum,pagesize);
        return companyRepository.findAll(pageable);
    }
    @RequestMapping(value = "/{id}/employees",method = RequestMethod.GET)
    public List<Employee> getEmployeesbyCompany(@PathVariable("id") long id){
        Company company=companyRepository.findOne(id);
        return company.getEmployees();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Company addCompany(Company company){
        return  companyRepository.save(company);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Company updateComapny(Company comany){
        return companyRepository.save(comany);
    }
    @RequestMapping(value = "/{id}",method =RequestMethod.DELETE )
    public boolean deleteCompany(@PathVariable("id") long id){
        companyRepository.delete(id);
        return true;
    }
}
