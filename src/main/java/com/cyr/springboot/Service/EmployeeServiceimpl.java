package com.cyr.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyr.springboot.Dao.EmployeeDao;
import com.cyr.springboot.model.Employee;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmployeeServiceimpl implements EmployeeService{
	@Autowired
	private  EmployeeDao employeeDao;

	@Override
	public Employee saveEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee;
		
	}
	public Employee getEmployee(int empid) {
	      return employeeDao.getById(empid);
	  }
	@Override
	  @Transactional
	  public void deleteEmployee(Integer employeeId) {
	      employeeDao.deleteById(employeeId);
	  }
	@Override
	  @Transactional
	  public List<Employee> getAllEmployees() {
		  return employeeDao.findAll();
	  }

}
