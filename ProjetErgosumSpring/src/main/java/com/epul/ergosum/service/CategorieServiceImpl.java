package com.epul.ergosum.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epul.ergosum.dao.CategorieDAO;
import com.epul.ergosum.dao.ComporteDAO;
import com.epul.ergosum.model.Categorie;
import com.epul.ergosum.model.Comporte;

/**
 * @author Corinne & Laura
 *
 */

public class CategorieServiceImpl implements CategorieService {

	@Autowired
	protected CategorieDAO	categorieDAO;

	@Autowired
	protected ComporteDAO	comporteDAO;

	@Override
	public List<Categorie> getAllCategorie() {
		return categorieDAO.getAllCategorie();
	}

	@Override
	public Categorie getCategorie(String id) {
		return categorieDAO.getCategorie(id);
	}

	@Override
	public HashMap<Categorie, Integer> getDictionnaires(int annee) {
		HashMap<Categorie, Integer> result = new HashMap<Categorie, Integer>();
		List<Comporte> comportes = comporteDAO.getAllComporte();
		List<Categorie> categories = categorieDAO.getAllCategorie();
		int qte;
		for (Categorie categorie : categories) {
			qte = 0;
			for (Comporte comporte : comportes) {
				if (comporte.getCatalogue().getAnnee() == annee && comporte.getJouet().getCategorie().getCodecateg().equals(categorie.getCodecateg())) {
					qte += comporte.getCatalogue().getQuantiteDistribuee();
				}
			}
			result.put(categorie, qte);
		}
		return result;
	}

	public CategorieDAO getCategorieDAO() {
		return categorieDAO;
	}

	public void setCategorieDAO(CategorieDAO categorieDAO) {
		this.categorieDAO = categorieDAO;
	}

	public ComporteDAO getComporteDAO() {
		return comporteDAO;
	}

	public void setComporteDAO(ComporteDAO comporteDAO) {
		this.comporteDAO = comporteDAO;
	}

}
