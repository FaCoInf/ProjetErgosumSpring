package com.epul.ergosum.dao;

import java.util.List;

import com.epul.ergosum.model.Comporte;

public interface ComporteDAO {

	public List<Comporte> getComporteBetweenYears(int anneeDebut, int nbAnnee);
}
