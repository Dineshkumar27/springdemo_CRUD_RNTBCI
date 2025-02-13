package com.example.springdemo.service;

import com.example.springdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

//    List<Employee> findAll();
List<Employee>  findAllByOrderByLastNameAsc();
void save(Employee employee);
Employee findById(int id);

    void deleteById(int id);
}