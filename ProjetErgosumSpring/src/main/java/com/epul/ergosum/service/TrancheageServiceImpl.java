package com.epul.ergosum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epul.ergosum.dao.TrancheageDAO;
import com.epul.ergosum.model.Trancheage;

public class TrancheageServiceImpl implements TrancheageService{

	@Autowired
	protected TrancheageDAO trancheageDAO;
	
	@Override
	public List<Trancheage> getAllTrancheage() {
		return trancheageDAO.getAllTranchage();
	}
	

}