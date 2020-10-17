package com.updev.springbootjdbctransactional.service;


import com.updev.springbootjdbctransactional.model.Employee;

import java.util.List;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> emps);
	void deleteEmployeeById(String empid);
}