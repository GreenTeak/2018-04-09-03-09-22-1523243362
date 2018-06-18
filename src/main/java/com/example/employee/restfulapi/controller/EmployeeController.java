package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees(){
        return  employeeRepository.findAll();
    }
    /*@RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") long id){
        return employeeRepository.findOne(id);
    }
    @RequestMapping(value = "page/{pageNum}/pageSize/{pagesize}",method=RequestMethod.GET)
    public Page<Employee> getPagebyEmployee(@PathVariable("pageNum") int pageNum,@PathVariable("pagesize") int pagesize){
        Pageable pageable=new PageRequest(pageNum,pagesize);
        return employeeRepository.findAll(pageable);
    }
    @RequestMapping(value = "/male",method = RequestMethod.GET)
    public List<Employee> getMaleEmployee(){
        return employeeRepository.findEmployeesByGenderEquals("male");
    }
    @RequestMapping(method = RequestMethod.POST)
    public Employee addEmployee(Employee employee){
        return  employeeRepository.save(employee);
    }
    @RequestMapping(value="/{id}",method =RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id")long id, Employee employee){
        Employee employee1=employeeRepository.findOne(id);
        employee1.setAge(employee.getAge());
        employee1.setCompanyId(employee.getCompanyId());
        employee1.setSalary(employee.getSalary());
        employee1.setName(employee.getName());
        return  employeeRepository.save(employee1);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("id") long id){
         employeeRepository.delete(id);
    }*/
}
