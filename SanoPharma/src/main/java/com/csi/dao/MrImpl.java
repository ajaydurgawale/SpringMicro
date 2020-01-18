package com.csi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Repository;

import com.csi.model.Drug;
import com.csi.model.MR;

@Repository
public class MrImpl implements MrDao {

	private SessionFactory factory;

	@Override
	public List<MR> getMrData() {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		List<MR> mrList = session.createQuery("select mr.mrName from MR mr").list();
		return mrList;

	}

	@Override
	public void saveMrData(MR mr) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("NAME:         "+ mr.getMrName());
		session.save(mr);
		transaction.commit();
	}

	@Override
	public void updateMrData(int mrId, MR mr) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Drug> drugList = new ArrayList<>();
		List<MR> mrList = session.createQuery("from MR").list();
		for (MR mrdata : mrList) {
			if (mrdata.getMrId() == mrId) {
				mrdata.setMrName(mr.getMrName());
				mrdata.setMrHighestEdu(mr.getMrHighestEdu());
				drugList.addAll(mrdata.getDrug());
				drugList.addAll(mr.getDrug());
				mrdata.setDrug(drugList);
				session.save(mrdata);
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

	public List<MR> getMrDatabyID(int mrId) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		ArrayList<MR> mrdatabyID = new ArrayList<>();
		List<MR> mrList = session.createQuery("from MR").list();
		for (MR mr : mrList) {
			if (mr.getMrId() == mrId) {
				mrdatabyID.add(mr);
			}
		}

		return mrdatabyID;
	}

}
