package com.csi.dao;

import java.util.List;

import com.csi.model.Employee;


public interface EmployeeDao {
	
	public List<Employee> employeelist();
	
	public void saveData(Employee employee);
	
	public void updateData(int empid, Employee employee);
	
	public void deleteData(int empid);
	
}
