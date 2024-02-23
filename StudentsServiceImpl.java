package com.jbk.springback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event.ID;

import com.jbk.springback.entity.Students;
import com.jbk.springback.exception.ResourceNotFoundException;
import com.jbk.springback.repository.StudentsRepository;
import com.jbk.springback.service.StudentsService;

@Service
public class StudentsServiceImpl implements StudentsService {

	private StudentsRepository employeeRepository;

	public StudentsServiceImpl(StudentsRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Students saveEmployee(Students employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Students> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Students getEmployeeById(long id) {
		Optional<Students> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Students updateEmployee(Students employee, long id) {
		// we need to check wheater the employee with given id is present or not

		Students existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

		existingEmployee.setName(employee.getName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setAddress(employee.getAddress());

		// save existing employee to DB
		employeeRepository.save(existingEmployee);

		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check wheather employee exit in a class or not
		Students existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);

	}


	

}
