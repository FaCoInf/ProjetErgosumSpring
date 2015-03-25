package com.epul.ergosum.model;

// Generated 24 avr. 2014 11:38:54 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Trancheage generated by hbm2java
 */
public class Trancheage implements java.io.Serializable {

	private String codetranche;
	private Integer agemin;
	private Integer agemax;
	private Set jouets = new HashSet(0);

	public Trancheage() {
	}

	public Trancheage(String codetranche) {
		this.codetranche = codetranche;
	}

	public Trancheage(String codetranche, Integer agemin, Integer agemax,
			Set jouets) {
		this.codetranche = codetranche;
		this.agemin = agemin;
		this.agemax = agemax;
		this.jouets = jouets;
	}

	public String getCodetranche() {
		return this.codetranche;
	}

	public void setCodetranche(String codetranche) {
		this.codetranche = codetranche;
	}

	public Integer getAgemin() {
		return this.agemin;
	}

	public void setAgemin(Integer agemin) {
		this.agemin = agemin;
	}

	public Integer getAgemax() {
		return this.agemax;
	}

	public void setAgemax(Integer agemax) {
		this.agemax = agemax;
	}

	public Set getJouets() {
		return this.jouets;
	}

	public void setJouets(Set jouets) {
		this.jouets = jouets;
	}

}