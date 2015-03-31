package com.epul.ergosum.dao;

import java.util.List;

import com.epul.ergosum.model.Jouet;

/**
 * Accès aux données de jouet
 * @author Laura
 *
 */
public interface JouetDAO {
	
	/**
	 * Renvoie la liste des jouets
	 * @return
	 */
	public List<Jouet> getAllJouet();
	
	
}
