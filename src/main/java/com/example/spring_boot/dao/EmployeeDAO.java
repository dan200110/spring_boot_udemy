package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
