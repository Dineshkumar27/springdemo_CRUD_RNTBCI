package com.example.springdemo.service;

import com.example.springdemo.dao.EmployeeRepository;
import com.example.springdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee findById(int id) {
        //get the Employee using the id
        Optional<Employee> theEmployee=employeeRepository.findById(id);
        Employee employee=null;
        //check the employee with the given id is present or not,if present get and store in employee
        if(theEmployee.isPresent()){
           employee= theEmployee.get();
        }else{
            //throw exception if the employee with id is not present
            throw  new RuntimeException("Employee not found with id "+id);
        }
        return employee;
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}