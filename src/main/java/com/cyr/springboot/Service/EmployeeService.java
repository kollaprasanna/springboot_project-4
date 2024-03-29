package com.cyr.springboot.Service;

import java.util.List;

import com.cyr.springboot.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public Employee getEmployee(int employeeid);
	public void deleteEmployee(Integer employeeId);
	public List<Employee> getAllEmployees();

}
