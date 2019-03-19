package com.workshop.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workshop.dao.EmployeeDao;
import com.workshop.model.Employee;

/**
 * 
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 * 
 */
@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	final static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	@Qualifier("a")
	EmployeeDao employeeDao;

	public Employee getEmployee(Long id) {
		logger.debug("Getting employee with id " + id);
		return employeeDao.findById(id);
	}

	/**
	 * Add new employee
	 * 
	 * @param employee:
	 *            Employee to add
	 */
	@Override
	@Transactional(readOnly = false)
	public void addNewEmployee(Employee employee) {
		Long id = (Long) employeeDao.save(employee);
		logger.debug("Id of new Employee " + id);
	}

}
