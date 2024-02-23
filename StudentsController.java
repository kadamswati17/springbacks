package com.jbk.springback.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event.ID;

import com.jbk.springback.entity.Students;
import com.jbk.springback.service.StudentsService;

@RestController
@RequestMapping("api/employee")
public class StudentsController {

	private StudentsService studentsService;

	public StudentsController(StudentsService studentsService) {
		super();
		this.studentsService = studentsService;
	}
	
	//build create employee REST API
	@PostMapping()
	public ResponseEntity<Students> saveEmployee(@RequestBody Students employee) {
		return new ResponseEntity<Students>(studentsService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//build all employee REST API
	@GetMapping
	public List<Students> getAllEmployee() {
		return studentsService.getAllEmployee();
	}
	
	//build get employee by id
	@GetMapping("{id}")
	public ResponseEntity<Students> getEmployeeById(@PathVariable("id") long id){
		return new ResponseEntity<Students>(studentsService.getEmployeeById(id), HttpStatus.OK);
	}
	
	//build update employee REST API
	
	@PutMapping("{id}")
	public ResponseEntity<Students> updateEmployee(@PathVariable("id") long id ,@RequestBody Students employee){
		return new ResponseEntity<Students>(studentsService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	//build delete employee REST API
	@DeleteMapping({"id"})
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		//delete employee from database
		studentsService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted Sucessfully...", HttpStatus.OK);
	}
	
	
	
	
}