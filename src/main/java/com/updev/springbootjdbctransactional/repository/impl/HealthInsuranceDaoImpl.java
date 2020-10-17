package com.updev.springbootjdbctransactional.repository.impl;

import com.updev.springbootjdbctransactional.model.EmployeeHealthInsurance;
import com.updev.springbootjdbctransactional.repository.HealthInsuranceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HealthInsuranceDaoImpl implements HealthInsuranceDao {

    @Qualifier("jdbc-techdb")
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public void registerEmployeeHealthInsurance(EmployeeHealthInsurance emp) {
        String sql = "INSERT INTO employeeHealthInsurance "
                + "(empId, healthInsuranceSchemeName, coverageAmount) VALUES (?, ?,?)";
        jdbc.update(sql,
                new Object[] { emp.getEmpId(), emp.getHealthInsuranceSchemeName(), emp.getCoverageAmount() });
    }

    @Override
    public void deleteEmployeeHealthInsuranceById(String empid) {
        String sql = "DELETE FROM employeeHealthInsurance WHERE empId = ?";
        jdbc.update(sql, new Object[] { empid });

    }
}
