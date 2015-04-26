package com.epul.ergosum.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.epul.ergosum.dao.JouetDAO;
import com.epul.ergosum.model.Jouet;

//@Service
public class JouetServiceImpl implements JouetService {

	@PostConstruct
	public void init() {
		System.out.println("initialisation du service jouet");
	}

	@Autowired
	protected JouetDAO	jouetDAO;

	@Override
	public List<Jouet> getAllJouet() {
		return jouetDAO.getAllJouet();
	}

	@Override
	public Jouet getJouet(String id) {
		return jouetDAO.getJouet(id);
	}

	@Override
	public int addJouet(Jouet jouet) {
		return jouetDAO.addJouet(jouet);
	}

	@Override
	public int modifyJouet(Jouet jouet) {
		return jouetDAO.modifyJouet(jouet);
	}

	@Override
	public int suppressJouet(Jouet jouet) {
		return jouetDAO.suppressJouet(jouet);
	}

	@Override
	public int suppressJouet(String id) {
		return jouetDAO.suppressJouet(id);
	}

	public JouetDAO getJouetDAO() {
		return jouetDAO;
	}

	public void setJouetDAO(JouetDAO jouetDAO) {
		this.jouetDAO = jouetDAO;
	}

}
