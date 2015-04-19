package com.epul.ergosum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epul.ergosum.model.Jouet;

public class JouetDAOImpl implements JouetDAO {

	private SessionFactory	sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jouet> getAllJouet() {

		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Jouet");
		List<Jouet> result = query.list();
		currentSession.close();

		return result;
	}

	@Override
	public Jouet getJouet(String id) {

		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("from Jouet where NUMERO = :identifier ").setParameter("identifier", id);
		Jouet result = (Jouet) query.uniqueResult();
		currentSession.close();

		return result;
	}

	@Override
	public int addJouet(Jouet jouet) {
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("insert into Jouet(numero, codecateg, codetranche, libelle)");
		query.setParameter("numero", jouet.getNumero());
		query.setParameter("codecateg", jouet.getCategorie().getCodecateg());
		query.setParameter("codetranche", jouet.getTrancheage().getCodetranche());
		query.setParameter("libelle", jouet.getLibelle());
		int result = query.executeUpdate();
		currentSession.close();
		return result;
	}

	@Override
	public int suppressJouet(Jouet jouet) {

		return suppressJouet(jouet.getNumero());
	}

	@Override
	public int suppressJouet(String id) {
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("delete Jouet where NUMERO = :identifier");
		query.setParameter("identifier", id);
		int result = query.executeUpdate();
		currentSession.close();

		return result;
	}

}
