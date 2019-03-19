package com.workshop;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.workshop.model.Employee;
import com.workshop.service.EmployeeService;

/**
 * 
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 * 
 */
@Component
public class MyApplication {

	final static Logger logger = Logger.getLogger(MyApplication.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.bytestree");
		ctx.refresh();

		EmployeeService empService = ctx.getBean(EmployeeService.class);
		Employee empNew = new Employee(1l, "Bytes", "Tree", "Senior Developer", 2000);

		// Save new employee
		empService.addNewEmployee(empNew);

		// Get saved employee
		Employee employee = empService.getEmployee(empNew.getId());
		logger.debug("Retrieving saved employee " + employee);
	}

}
