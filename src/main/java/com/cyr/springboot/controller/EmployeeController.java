package com.cyr.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cyr.springboot.Dao.EmployeeDao;
import com.cyr.springboot.Service.EmployeeService;
import com.cyr.springboot.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao repo;
	@Autowired
	private EmployeeService employeeservice;
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> listEmployee() {
		return new ResponseEntity<List<Employee>>(employeeservice.getAllEmployees(),HttpStatus.OK);
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		if (employee.getId() == 0) {
			employeeservice.saveEmployee(employee);
		}
		return "Saved Successfully";
	}
       @GetMapping("/employeeById/{id}")
       public ResponseEntity<Employee>getcById(@PathVariable int id){
    	   if(repo.findById(id).isPresent()){
    		   return new ResponseEntity<Employee>(employeeservice.getEmployee(id),HttpStatus.OK);
    	   }
    	   return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
       }
       @DeleteMapping("/delete/{id}")
       public void deleteById(@PathVariable("id")int id){
    	   repo.deleteById(id);
    	}
}

