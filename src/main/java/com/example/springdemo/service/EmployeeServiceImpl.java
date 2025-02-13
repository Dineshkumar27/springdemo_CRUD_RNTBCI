package com.example.springdemo.service;

import com.example.springdemo.dao.EmployeeRepository;
import com.example.springdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }


    @Override
    public List<Employee> findAllByOrderByLastNameAsc() {
//        List<Employee> employeeList=employeeRepository.findAll();
        List<Employee> employeeList=employeeRepository.findAllByOrderByLastNameAsc();
        return employeeList;
    }

    @Override
    public void save(Employee employee) {

         employeeRepository.save(employee);
    }
}