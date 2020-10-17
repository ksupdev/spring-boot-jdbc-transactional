package com.updev.springbootjdbctransactional;

import com.updev.springbootjdbctransactional.model.Employee;
import com.updev.springbootjdbctransactional.model.EmployeeHealthInsurance;
import com.updev.springbootjdbctransactional.service.EmployeeService;
import com.updev.springbootjdbctransactional.service.OrganizationService;
import com.updev.springbootjdbctransactional.service.impl.InvalidInsuranceAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootJdbcTransactionalApplication {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	OrganizationService organizationService;

//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootJdbcTransactionalApplication.class, args);
//	}

	public static void main(String[] args) throws InvalidInsuranceAmountException {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcTransactionalApplication.class, args);
		OrganizationService organizationService = context.getBean(OrganizationService.class);

		EmployeeService employeeService = context.getBean(EmployeeService.class);


		/*
		Employee emp= new Employee();
		emp.setEmpId("emp1");
		emp.setEmpName("emp1");

		EmployeeHealthInsurance employeeHealthInsurance= new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp1");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(0);

		organizationService.joinOrganization(emp, employeeHealthInsurance)
		*/

		Employee emp= new Employee();
		emp.setEmpId("emp0.1");
		emp.setEmpName("emp0.1");

		Employee emp1= new Employee();
		emp1.setEmpId("emp0.12");
		emp1.setEmpName("emp0.12");

		Employee emp2= new Employee();
		emp2.setEmpId("emp0.2");
		emp2.setEmpName("emp0.2");

		List<Employee> employees = new ArrayList<>();
		employees.add(emp);
		employees.add(emp1);
		employees.add(emp2);

		employeeService.insertEmployees(employees);


;
	}

}
