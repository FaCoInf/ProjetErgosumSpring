package com.epul.ergosum.dao;

import java.util.List;

import com.epul.ergosum.model.Catalogue;

/**
 * Accès aux données de catalogue
 * @author Corinne & Laura
 *
 */

public interface CatalogueDAO {

	/**
	 * Renvoie la liste des catalogues
	 * @return
	 */
	public List<Catalogue> getAllCatalogue();

	public Catalogue getCatalogue(int id);

	public int addCatalogue(Catalogue catalogue);

	public int modifyCatalogue(Catalogue catalogue);

	public List<Catalogue> getNbCatalogueFromYear(int anneeDepart, int nbAnnee);
}
