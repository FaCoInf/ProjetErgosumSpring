package com.epul.ergosum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epul.ergosum.dao.CatalogueDAO;
import com.epul.ergosum.dao.ComporteDAO;
import com.epul.ergosum.metier.CatalogueQuantites;
import com.epul.ergosum.model.Catalogue;
import com.epul.ergosum.model.Comporte;


/**
 * @author Corinne & Laura
 *
 */

public class CatalogueServiceImpl implements CatalogueService {

	@Autowired
	protected CatalogueDAO catalogueDAO;

	@Autowired
	protected ComporteDAO comporteDAO;

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
	public List<CatalogueQuantites> getCatalogueBetweenYears(int anneeDepart,
			int nbAnnee) {
		List<Comporte> comportes = comporteDAO.getComporteBetweenYears(
				anneeDepart, nbAnnee);
		List<CatalogueQuantites> catalogueQuantite = new ArrayList<CatalogueQuantites>();
		CatalogueQuantites cataQuantite;
		for (Comporte comporte : comportes) {
			cataQuantite = new CatalogueQuantites();
			cataQuantite.setId(String.valueOf(comporte.getCatalogue()
					.getAnnee()));
			cataQuantite.setQuantiteDistribuee(String.valueOf(comporte
					.getCatalogue().getQuantiteDistribuee()));
			cataQuantite.setQuantite(String.valueOf(comporte.getQuantite()));
			cataQuantite.setDifference(String.valueOf(comporte.getQuantite()
					- comporte.getCatalogue().getQuantiteDistribuee()));

			catalogueQuantite.add(cataQuantite);
		}

		return catalogueQuantite;
	}

	public CatalogueDAO getCatalogueDAO() {
		return catalogueDAO;
	}

	public void setCatalogueDAO(CatalogueDAO catalogueDAO) {
		this.catalogueDAO = catalogueDAO;
	}

	public ComporteDAO getComporteDAO() {
		return comporteDAO;
	}

	public void setComporteDAO(ComporteDAO comporteDAO) {
		this.comporteDAO = comporteDAO;
	}

}
