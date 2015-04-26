package com.epul.ergosum.dao;

import java.util.List;

import com.epul.ergosum.model.Comporte;

/**
 * Accès aux données de Comporte
 * @author Corinne & Laura
 *
 */

public interface ComporteDAO {

	public List<Comporte> getAllComporte();

	public List<Comporte> getComporteBetweenYears(int anneeDebut, int nbAnnee);
}
