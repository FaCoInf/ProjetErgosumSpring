package com.epul.ergosum.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epul.ergosum.model.Catalogue;
import com.epul.ergosum.model.Jouet;

public class CatalogueDAOImpl implements CatalogueDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Catalogue> getAllCatalogue() {

		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Catalogue");

		List<Catalogue> Catalogues = query.list();
		currentSession.close();
		return Catalogues;
	}

}
