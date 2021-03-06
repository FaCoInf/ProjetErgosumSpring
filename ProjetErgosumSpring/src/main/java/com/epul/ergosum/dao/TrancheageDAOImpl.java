package com.epul.ergosum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epul.ergosum.model.Categorie;
import com.epul.ergosum.model.Trancheage;

/**
 * Accès aux données de TrancheAge
 * @author Laura & Corinne
 *
 */

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
	
	@Override
	public Trancheage getTrancheage(String id) {

		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Trancheage where CODETRANCHE = :identifier ").setParameter("identifier", id);
		Trancheage result = (Trancheage) query.uniqueResult();
		currentSession.close();

		return result;
	}
	
	

}
