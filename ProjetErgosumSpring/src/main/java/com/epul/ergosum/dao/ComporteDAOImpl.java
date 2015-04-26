package com.epul.ergosum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epul.ergosum.model.Comporte;

/**
 * Accès aux données de Comporte
 * @author Corinne & Laura
 *
 */

public class ComporteDAOImpl implements ComporteDAO {
	private SessionFactory	sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Comporte> getComporteBetweenYears(int anneeDebut, int nbAnnee) {
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Comporte where annee between :anneeDep and :anneeFin");
		query.setParameter("anneeDep", anneeDebut);
		query.setParameter("anneeFin", anneeDebut + nbAnnee);
		List<Comporte> comportes = query.list();
		currentSession.close();

		return comportes;
	}

	@Override
	public List<Comporte> getAllComporte() {
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Comporte");
		List<Comporte> comportes = query.list();
		currentSession.close();

		return comportes;
	}

}
