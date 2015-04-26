package com.epul.ergosum.service;

import java.util.List;

import com.epul.ergosum.model.Catalogue;

public interface CatalogueService {

	public List<Catalogue> getAllCatalogue();

	public Catalogue getCatalogue(int id);

	public int addCatalogue(Catalogue catalogue);

	public int modifyCatalogue(Catalogue catalogue);

	public List<Catalogue> getNbCatalogueFromYear(int anneeDepart, int nbAnnee);
}
