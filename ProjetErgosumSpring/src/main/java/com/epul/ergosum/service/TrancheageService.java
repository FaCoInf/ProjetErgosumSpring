package com.epul.ergosum.service;

import java.util.List;

import com.epul.ergosum.model.Trancheage;

/**
 * @author Corinne & Laura
 *
 */

public interface TrancheageService {

	public List<Trancheage> getAllTrancheage();

	public Trancheage getTrancheage(String id);
}
