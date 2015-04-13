package com.epul.ergosum.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epul.ergosum.model.Catalogue;
import com.epul.ergosum.model.Jouet;

//@Repository
public class CatalogueDAOImpl implements CatalogueDAO {

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
	public List<Catalogue> getAllCatalogue() {

		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Catalogue");

		List<Catalogue> Catalogues = query.list();

		return Catalogues;
	}

}
