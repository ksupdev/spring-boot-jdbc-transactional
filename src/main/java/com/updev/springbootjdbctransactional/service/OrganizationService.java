package com.updev.springbootjdbctransactional.service;


import com.updev.springbootjdbctransactional.model.Employee;
import com.updev.springbootjdbctransactional.model.EmployeeHealthInsurance;
import com.updev.springbootjdbctransactional.service.impl.InvalidInsuranceAmountException;

public interface OrganizationService {
	
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) throws InvalidInsuranceAmountException;
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
}
