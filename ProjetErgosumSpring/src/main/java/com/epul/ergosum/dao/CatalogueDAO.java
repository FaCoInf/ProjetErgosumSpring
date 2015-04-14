package com.epul.ergosum.dao;

import java.util.List;

import com.epul.ergosum.model.Catalogue;
import com.epul.ergosum.model.Jouet;

/**
 * Accès aux données de catalogue
 * @author Corinne
 *
 */
public interface CatalogueDAO {
	
	/**
	 * Renvoie la liste des catalogues
	 * @return
	 */
	public List<Catalogue> getAllCatalogue();
	
	
}
