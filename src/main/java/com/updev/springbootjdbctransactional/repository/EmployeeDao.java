package com.updev.springbootjdbctransactional.repository;

import com.updev.springbootjdbctransactional.model.Employee;

public interface EmployeeDao {
    void insertEmployee(Employee cus);
    void deleteEmployeeById(String empid);
}
