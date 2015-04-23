package com.epul.ergosum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epul.ergosum.model.Categorie;

public class CategorieDAOImpl implements CategorieDAO {

	private SessionFactory	sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCatalog() {
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Categorie");
		List<Categorie> categories = query.list();
		currentSession.close();

		return categories;
	}
	

}
