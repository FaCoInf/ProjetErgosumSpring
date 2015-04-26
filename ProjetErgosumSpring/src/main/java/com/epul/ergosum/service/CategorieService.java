package com.epul.ergosum.service;

import java.util.List;

import com.epul.ergosum.model.Categorie;

public interface CategorieService {

	public List<Categorie> getAllCategorie();

	public Categorie getCategorie(String id);
}
