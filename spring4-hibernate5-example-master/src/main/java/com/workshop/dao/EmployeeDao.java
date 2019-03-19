package com.workshop.dao;

import java.io.Serializable;

import com.workshop.model.Employee;

public interface EmployeeDao {

	Serializable save(Employee employee);

	Employee findById(Serializable id);

}
