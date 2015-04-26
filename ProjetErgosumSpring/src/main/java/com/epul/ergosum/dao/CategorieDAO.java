package com.epul.ergosum.dao;

import java.util.List;

import com.epul.ergosum.model.Categorie;

/**
 * Accès aux données de categorie
 * @author Corinne & Laura
 *
 */

public interface CategorieDAO {

	public List<Categorie> getAllCategorie();

	public Categorie getCategorie(String id);
}
