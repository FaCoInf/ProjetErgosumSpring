package com.epul.ergosum.service;

import java.util.HashMap;
import java.util.List;

import com.epul.ergosum.model.Categorie;

public interface CategorieService {

	public List<Categorie> getAllCategorie();

	public Categorie getCategorie(String id);

	public HashMap<Categorie, Integer> getDictionnaires(int annee);
}
