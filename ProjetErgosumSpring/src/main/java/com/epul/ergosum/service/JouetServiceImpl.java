package com.epul.ergosum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epul.ergosum.dao.JouetDAO;
import com.epul.ergosum.model.Jouet;

public class JouetServiceImpl implements JouetService{

	@Autowired
	protected JouetDAO jouetDAO;
	
	@Override
	public List<Jouet> getAllJouet()
	{
		return jouetDAO.getAllJouet();
	}
	
}
