package com.epul.ergosum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epul.ergosum.dao.CatalogueDAO;
import com.epul.ergosum.model.Catalogue;

public class CatalogueServiceImpl implements CatalogueService{

	@Autowired
	protected CatalogueDAO catalogueDAO;
	
	@Override
	public List<Catalogue> getAllCatalogue() {
		return catalogueDAO.getAllCatalogue();
	}
	

}
