package com.updev.springbootjdbctransactional.service.impl;


import com.updev.springbootjdbctransactional.model.EmployeeHealthInsurance;
import com.updev.springbootjdbctransactional.repository.HealthInsuranceDao;
import com.updev.springbootjdbctransactional.service.HealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

	@Autowired
	HealthInsuranceDao healthInsuranceDao;

	@Override
	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException {
		if (employeeHealthInsurance.getCoverageAmount() <= 0) {
			throw new InvalidInsuranceAmountException("Coverage Amount Should not be negative");
		}
		healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	public void deleteEmployeeHealthInsuranceById(String empid) {
		healthInsuranceDao.deleteEmployeeHealthInsuranceById(empid);
	}

}