package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Repository;

import com.csi.model.MR;

@Repository
public class MrImpl implements MrDao {

	private SessionFactory factory;

	@Override
	public List<MR> getMrData() {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		List<MR> mrList = session.createQuery("from MR").list();
		return mrList;

	}

	@Override
	public void saveMrData(MR mr) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(mr);
		transaction.commit();
		}

	@Override
	public void updateMrData(int mrId, MR mr) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<MR> mrList = session.createQuery("from MR").list();
		for (MR mrdata : mrList) {
			if (mrdata.getMrId() == mrId) {
				mrdata.setMrName(mr.getMrName());
				mrdata.setMrHighestEdu(mr.getMrHighestEdu());
				session.update(mrdata);
				transaction.commit();
			}
		}
	}

	@Override
	public void deleteMrData(int mrId) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<MR> mrList = session.createQuery("from MR").list();
		for (MR mrdata : mrList) {
			if (mrdata.getMrId() == mrId) {
				session.delete(mrdata);
				transaction.commit();
			}
		}

	}
	/*public List<Customer> getCustomerListbyID(int customerId) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		ArrayList<Customer> custdatabyID= new ArrayList<>();
		List<Customer> custList = session.createQuery("from Customer").list();
		for(Customer cust:custList)
		{
			if(cust.getCustomerId()==customerId)
			{
				custdatabyID.add(cust);
			}
		}
		
		return custdatabyID;
	}*/

}
