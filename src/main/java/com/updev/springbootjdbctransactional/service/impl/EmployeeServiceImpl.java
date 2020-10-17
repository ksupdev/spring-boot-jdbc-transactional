package com.updev.springbootjdbctransactional.service.impl;


import com.updev.springbootjdbctransactional.model.Employee;
import com.updev.springbootjdbctransactional.repository.EmployeeDao;
import com.updev.springbootjdbctransactional.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	@Transactional()
	public void insertEmployees(List<Employee> emps) {
		for (Employee em: emps) {
			employeeDao.insertEmployee(em);
		}
	}

	@Override
	public void deleteEmployeeById(String empid) {
		employeeDao.deleteEmployeeById(empid);		
	}

}