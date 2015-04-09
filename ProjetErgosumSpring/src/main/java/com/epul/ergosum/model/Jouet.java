package com.epul.ergosum.model;

//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "JOUET")
//public class Jouet {
//
//	@Id
//	@Column(name = "NUMERO")
//	private String numero;
//
//	private String codecateg;
//
//	private String codetranche;
//
//	private String libelle;
//
//	public String getNumero() {
//		return numero;
//	}
//
//	public void setNumero(String numero) {
//		this.numero = numero;
//	}
//
//	public String getCodecateg() {
//		return codecateg;
//	}
//
//	public void setCodecateg(String codecateg) {
//		this.codecateg = codecateg;
//	}
//
//	public String getCodetranche() {
//		return codetranche;
//	}
//
//	public void setCodetranche(String codetranche) {
//		this.codetranche = codetranche;
//	}
//
//	public String getLibelle() {
//		return libelle;
//	}
//
//	public void setLibelle(String libelle) {
//		this.libelle = libelle;
//	}
//
//}
// Generated 24 avr. 2014 11:38:54 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* Jouet generated by hbm2java
*/
@Entity
@Table(name = "JOUET")
public class Jouet implements java.io.Serializable {

	private static final long serialVersionUID = -746025709126919028L;

	private String numero;
	private Categorie categorie;
	private Trancheage trancheage;
	private String libelle;
	private Set<Comporte> comportes = new HashSet<Comporte>(0);

	public Jouet() {
	}

	public Jouet(String numero, Categorie categorie, Trancheage trancheage) {
		this.numero = numero;
		this.categorie = categorie;
		this.trancheage = trancheage;
	}

	public Jouet(String numero, Categorie categorie, Trancheage trancheage,
			String libelle, Set<Comporte> comportes) {
		this.numero = numero;
		this.categorie = categorie;
		this.trancheage = trancheage;
		this.libelle = libelle;
		this.comportes = comportes;
	}

	@Id
	@Column(name = "NUMERO")
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@ManyToOne(targetEntity = Categorie.class)
	@JoinColumn(name = "CODECATEG")
	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@ManyToOne
	@JoinColumn(name = "CODETRANCHE")
	public Trancheage getTrancheage() {
		return this.trancheage;
	}

	public void setTrancheage(Trancheage trancheage) {
		this.trancheage = trancheage;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jouet")
	public Set<Comporte> getComportes() {
		return this.comportes;
	}

	public void setComportes(Set<Comporte> comportes) {
		this.comportes = comportes;
	}

}
