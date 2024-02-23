package com.jbk.springback.service;

import java.util.List;

import org.yaml.snakeyaml.events.Event.ID;

import com.jbk.springback.entity.Students;

public interface StudentsService {

	Students saveEmployee(Students employee);
		
	List<Students> getAllEmployee();

	Students getEmployeeById(long id);
	
	Students updateEmployee(Students employee, long id);

	void deleteEmployee(long id);


}