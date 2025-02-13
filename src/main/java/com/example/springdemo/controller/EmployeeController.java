package com.example.springdemo.controller;

import com.example.springdemo.entity.Employee;
import com.example.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")  //http://localhost:9911/employees
public class EmployeeController {
     @Autowired
    private EmployeeService employeeService;



    @GetMapping("/list")
    public String showList(Model theModel){

        List<Employee> employeeList=employeeService.findAllByOrderByLastNameAsc();
        theModel.addAttribute("employees",employeeList);

        return "list-employees";
    }


}