package com.epul.ergosum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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
		List<Jouet> jouets = query.list();
		currentSession.close();

		return jouets;
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
	@Transactional
	// TODO ajouter au catalogue la quantit� du jouet ajout�
	public int addJouet(Jouet jouet) {
		Session currentSession = this.sessionFactory.openSession();
		currentSession.beginTransaction();
		currentSession.save(jouet);
		currentSession.getTransaction().commit();
		currentSession.close();
		return Integer.parseInt(jouet.getNumero());
	}

	@Override
	@Transactional
	public int modifyJouet(Jouet jouet) {
		// suppressJouet(jouet);
		// return addJouet(jouet);
		Session currentSession = this.sessionFactory.openSession();
		Query query = currentSession.createQuery("update Jouet set CODECATEG = :codecateg, CODETRANCHE = :codetranche, LIBELLE = :libelle where NUMERO = :numero ");
		query.setParameter("numero", jouet.getNumero());
		query.setParameter("libelle", jouet.getLibelle());
		query.setParameter("codecateg", jouet.getCategorie().getCodecateg());
		query.setParameter("codetranche", jouet.getTrancheage().getCodetranche());
		int result = query.executeUpdate();
		currentSession.close();
		return result;
	}

	@Override
	@Transactional
	public int suppressJouet(Jouet jouet) {

		return suppressJouet(jouet.getNumero());
	}

	@Override
	@Transactional
	// TODO soustraire dans catalogue la quantit� du joeut associ�
	public int suppressJouet(String id) {
		Session currentSession = this.sessionFactory.openSession();

		Query query = currentSession.createQuery("delete Comporte where NUMERO = :identifier");
		query.setParameter("identifier", id);
		query.executeUpdate();

		query = currentSession.createQuery("delete Jouet where NUMERO = :identifier");
		query.setParameter("identifier", id);
		int result = query.executeUpdate();
		currentSession.close();

		return result;
	}

}
