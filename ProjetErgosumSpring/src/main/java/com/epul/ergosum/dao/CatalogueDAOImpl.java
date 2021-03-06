package com.epul.ergosum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epul.ergosum.model.Catalogue;

/**
 * Accès aux données de catalogue
 * @author Corinne & Laura
 *
 */

public class CatalogueDAOImpl implements CatalogueDAO {

	private SessionFactory	sessionFactory;

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

	@Override
	public Catalogue getCatalogue(int id) {

		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Catalogue where ANNEE = :identifier ").setParameter("identifier", id);
		Catalogue result = (Catalogue) query.uniqueResult();
		currentSession.close();

		return result;
	}

	@Override
	public int addCatalogue(Catalogue catalogue) {
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("insert into Catalogue(annee, quantiteDistribuee)");
		query.setParameter("annee", catalogue.getAnnee());
		query.setParameter("quantiteDistribuee", catalogue.getQuantiteDistribuee());
		int result = query.executeUpdate();
		currentSession.close();
		return result;
	}

	@Override
	public int modifyCatalogue(Catalogue catalogue) {
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("update Catalogue set quantiteDistribuee = :quantiteDistribuee where annee = :annee)");
		query.setParameter("annee", catalogue.getAnnee());
		query.setParameter("quantiteDistribuee", catalogue.getQuantiteDistribuee());
		int result = query.executeUpdate();
		currentSession.close();
		return result;
	}

	@Override
	public List<Catalogue> getNbCatalogueFromYear(int anneeDepart, int nbAnnee) {
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Catalogue where annee between :anneeDep and :anneeFin");
		query.setParameter("anneeDep", anneeDepart);
		query.setParameter("anneeFin", anneeDepart + nbAnnee);
		List<Catalogue> Catalogues = query.list();
		currentSession.close();
		return Catalogues;
	}

}
