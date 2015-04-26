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
	public List<Categorie> getAllCategorie() {
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Categorie");
		List<Categorie> categories = query.list();
		currentSession.close();

		return categories;
	}

	@Override
	public Categorie getCategorie(String id) {

		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Categorie where CODECATEG = :identifier ").setParameter("identifier", id);
		Categorie result = (Categorie) query.uniqueResult();
		currentSession.close();

		return result;
	}

}
