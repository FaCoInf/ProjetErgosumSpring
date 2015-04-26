package com.epul.ergosum.service;

import java.util.List;

import com.epul.ergosum.model.Jouet;
/**
 * @author Corinne & Laura
 *
 */
public interface JouetService {

	public List<Jouet> getAllJouet();

	/**
	 * renvoie un {@link Jouet} selon son id
	 * @param id du jouet a trouver
	 * @return {@link Jouet}
	 */
	public Jouet getJouet(String id);

	/**
	 * Ajoute un jouet
	 * @param jouet à ajouter
	 * @return int
	 */
	public int addJouet(Jouet jouet);

	public int modifyJouet(Jouet jouet);

	/**
	 * supprime un jouet
	 * @param jouet a suprimer
	 * @return int
	 */
	public int suppressJouet(Jouet jouet);

	/**
	 * supprime un jouet
	 * @param id du jouet a supprimer
	 * @return int
	 */
	public int suppressJouet(String id);

}
