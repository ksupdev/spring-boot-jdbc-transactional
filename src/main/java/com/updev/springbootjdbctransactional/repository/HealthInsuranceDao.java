package com.updev.springbootjdbctransactional.repository;

import com.updev.springbootjdbctransactional.model.EmployeeHealthInsurance;

public interface HealthInsuranceDao {
    void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);
    void deleteEmployeeHealthInsuranceById(String empid);
}
