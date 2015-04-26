package com.epul.ergosum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epul.ergosum.dao.CatalogueDAO;
import com.epul.ergosum.model.Catalogue;

public class CatalogueServiceImpl implements CatalogueService {

	@Autowired
	protected CatalogueDAO	catalogueDAO;

	@Override
	public List<Catalogue> getAllCatalogue() {
		return catalogueDAO.getAllCatalogue();
	}

	@Override
	public Catalogue getCatalogue(int id) {
		return catalogueDAO.getCatalogue(id);
	}

	@Override
	public int addCatalogue(Catalogue catalogue) {
		return catalogueDAO.addCatalogue(catalogue);
	}

	@Override
	public int modifyCatalogue(Catalogue catalogue) {
		return catalogueDAO.modifyCatalogue(catalogue);
	}

	@Override
	public List<Catalogue> getNbCatalogueFromYear(int anneeDepart, int nbAnnee) {
		System.out.println(catalogueDAO.getNbCatalogueFromYear(anneeDepart, nbAnnee).toString());

		return catalogueDAO.getNbCatalogueFromYear(anneeDepart, nbAnnee);
	}

	public CatalogueDAO getCatalogueDAO() {
		return catalogueDAO;
	}

	public void setCatalogueDAO(CatalogueDAO catalogueDAO) {
		this.catalogueDAO = catalogueDAO;
	}

}
