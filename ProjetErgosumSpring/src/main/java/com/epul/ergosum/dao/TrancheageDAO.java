package com.epul.ergosum.dao;
import java.util.List;

/**
 * Accès aux données de TrancheAge
 * @author Laura & Corinne
 *
 */

import com.epul.ergosum.model.Trancheage;
public interface TrancheageDAO {

	public List<Trancheage> getAllTranchage();
	public Trancheage getTrancheage(String id);
}
