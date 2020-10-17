package com.updev.springbootjdbctransactional.service;


import com.updev.springbootjdbctransactional.model.EmployeeHealthInsurance;
import com.updev.springbootjdbctransactional.service.impl.InvalidInsuranceAmountException;

public interface HealthInsuranceService {
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException;

	void deleteEmployeeHealthInsuranceById(String empid);
}