package com.updev.springbootjdbctransactional.repository.impl;

import com.updev.springbootjdbctransactional.model.Employee;
import com.updev.springbootjdbctransactional.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Qualifier("jdbc-techdb")
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public void insertEmployee(Employee emp) {
        String sql = "INSERT INTO employee " + "(empId, empName) VALUES (?, ?)";
        jdbc.update(sql, new Object[] { emp.getEmpId(), emp.getEmpName() });
    }

    @Override
    public void deleteEmployeeById(String empid) {
        String sql = "DELETE FROM employee WHERE empId = ?";
        jdbc.update(sql, new Object[] { empid });

    }
}
