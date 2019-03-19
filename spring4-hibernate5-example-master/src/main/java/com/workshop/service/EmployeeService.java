package com.workshop.service;

import com.workshop.model.Employee;

public interface EmployeeService {

	Employee getEmployee(Long id);

	void addNewEmployee(Employee employee);
}
