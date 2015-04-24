package com.epul.ergosum.dao;
import java.util.List;

import com.epul.ergosum.model.Trancheage;
public interface TrancheageDAO {

	public List<Trancheage> getAllTranchage();
	public Trancheage getTrancheage(String id);
}
