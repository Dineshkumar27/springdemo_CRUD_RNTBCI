package com.example.springdemo.controller;

import com.example.springdemo.entity.Employee;
import com.example.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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


    @GetMapping("/showEmployeeForm")
    public String showEmployeeForm(Model theModel){


        theModel.addAttribute("employees",new Employee());

        return "employee-reg-form";
    }

    @PostMapping("/save")
    public String saveEmployeee(@ModelAttribute("employee")Employee employee,Model theModel){
        //save the employee using service
        employeeService.save(employee);
        //after saving redirecting to list of employee to see the changes
        return "redirect:/employees/list";
    }

}