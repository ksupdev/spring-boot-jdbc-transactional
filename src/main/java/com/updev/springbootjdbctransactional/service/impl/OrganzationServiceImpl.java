package com.updev.springbootjdbctransactional.service.impl;

import com.updev.springbootjdbctransactional.model.Employee;
import com.updev.springbootjdbctransactional.model.EmployeeHealthInsurance;
import com.updev.springbootjdbctransactional.service.EmployeeService;
import com.updev.springbootjdbctransactional.service.HealthInsuranceService;
import com.updev.springbootjdbctransactional.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrganzationServiceImpl implements OrganizationService {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	HealthInsuranceService healthInsuranceService;

	@Override
	@Transactional(rollbackFor = InvalidInsuranceAmountException.class)
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException {
		employeeService.insertEmployee(employee);
		try {
			healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
		} catch (InvalidInsuranceAmountException e) {
			throw new InvalidInsuranceAmountException("Exception is thrown");
		}
	}

	@Override
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.deleteEmployeeById(employee.getEmpId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
	}
}