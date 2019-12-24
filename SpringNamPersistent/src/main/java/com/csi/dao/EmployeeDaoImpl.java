package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;


import com.csi.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	SessionFactory factory;
	
	@Override
	public List<Employee> getEmployeeList() {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		List<Employee> emplist = session.createQuery("from Employee").list();
		return emplist;
	}

	@Override
	public void saveEmployee(Employee employee) {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
	}

	@Override
	public void updateEmployee(Employee employee, int empId) {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> emplist = session.createQuery("from Employee").list();
		for(Employee emp: emplist)
		{
			if(emp.getEmpId()==empId){
				emp.setEmpName(employee.getEmpName());
				emp.setEmpSalary(employee.getEmpSalary());
				session.save(emp);
				transaction.commit();
			}
		}
	}

	@Override
	public void deleteEmployee(int empId) {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> emplist = session.createQuery("from Employee").list();
		for(Employee emp: emplist)
		{
			if(emp.getEmpId()==empId){
				session.delete(emp);
				transaction.commit();
			}
		}
		
	}

}
