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
	

	public SessionFactory factory;
	@Override
	public List<Employee> employeelist() {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		List<Employee> emplist = session.createQuery("from Employee").list();
		
		return emplist;
	}

	@Override
	public void saveData(Employee emp) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(emp);
		transaction.commit();
	}

	@Override
	public void updateData(int empid, Employee employee) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> emplist = session.createQuery("from Employee").list();
		for(Employee emp : emplist){
			if(emp.getEmpId()==empid){
				emp.setEmpId(employee.getEmpId());
				emp.setEmpName(employee.getEmpName());
				emp.setEmpSname(employee.getEmpSname());
				emp.setEmpAge(employee.getEmpAge());
				session.save(emp);
				transaction.commit();
			}
		}
		
	}

	@Override
	public void deleteData(int empid) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> emplist = session.createQuery("from Employee").list();
		for(Employee emp : emplist){
			if(emp.getEmpId()==empid){
				session.delete(emp);
				transaction.commit();
			}
		}
		
	}

	

}
