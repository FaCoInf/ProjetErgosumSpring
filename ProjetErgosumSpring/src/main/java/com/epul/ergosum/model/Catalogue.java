package com.epul.ergosum.model;

// Generated 24 avr. 2014 11:38:54 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Catalogue generated by hbm2java
 */
@Entity
@Table(name = "CATALOGUE")
public class Catalogue implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1955623760524652326L;

	private int annee;
	private int quantiteDistribuee;
	private Set<Comporte> comportes = new HashSet<Comporte>(0);

	public Catalogue() {
	}

	public Catalogue(int annee, int quantiteDistribuee) {
		this.annee = annee;
		this.quantiteDistribuee = quantiteDistribuee;
	}

	public Catalogue(int annee, int quantiteDistribuee, Set<Comporte> comportes) {
		this.annee = annee;
		this.quantiteDistribuee = quantiteDistribuee;
		this.comportes = comportes;
	}

	@Id
	@Column(name = "ANNEE")
	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getQuantiteDistribuee() {
		return this.quantiteDistribuee;
	}

	public void setQuantiteDistribuee(int quantiteDistribuee) {
		this.quantiteDistribuee = quantiteDistribuee;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogue")
	public Set<Comporte> getComportes() {
		return this.comportes;
	}

	public void setComportes(Set<Comporte> comportes) {
		this.comportes = comportes;
	}

}
