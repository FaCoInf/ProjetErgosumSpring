package com.epul.ergosum.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epul.ergosum.model.Jouet;

//@Repository
public class JouetDAOImpl implements JouetDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@PostConstruct
	protected void init() {
		System.out.println("Initialisation");

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jouet> getAllJouet() {

		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Jouet");

		List<Jouet> jouets = query.list();

		for (Jouet jouet : jouets) {
			System.out.println(jouet.toString());
		}

		return null;
	}

}
