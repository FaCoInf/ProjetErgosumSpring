package com.epul.ergosum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epul.ergosum.dao.CategorieDAO;
import com.epul.ergosum.model.Categorie;

public class CategorieServiceImpl implements CategorieService {

	@Autowired
	protected CategorieDAO	categorieDAO;

	@Override
	public List<Categorie> getAllCategorie() {
		return categorieDAO.getAllCategorie();
	}

	@Override
	public Categorie getCategorie(String id) {
		return categorieDAO.getCategorie(id);
	}

	public CategorieDAO getCategorieDAO() {
		return categorieDAO;
	}

	public void setCategorieDAO(CategorieDAO categorieDAO) {
		this.categorieDAO = categorieDAO;
	}
}
