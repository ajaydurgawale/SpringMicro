package com.csi.dao;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployeeList();

	public void saveEmployee(Employee employee);

	public void updateEmployee(Employee employee, int empId);

	public void deleteEmployee(int empId);
}
