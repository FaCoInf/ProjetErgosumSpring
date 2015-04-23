package com.epul.ergosum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epul.ergosum.model.Trancheage;

public class TrancheageDAOImpl implements TrancheageDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Trancheage> getAllTranchage() {

		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Trancheage");

		List<Trancheage> trancheages = query.list();
		currentSession.close();
		return trancheages;
	}
	

}
