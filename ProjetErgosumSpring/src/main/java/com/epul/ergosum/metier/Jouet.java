package com.epul.ergosum.metier;

import java.util.HashSet;
import java.util.Set;

public class Jouet {
	private String numero;
	private Categorie categorie;
	private Trancheage trancheage;
	private String libelle;
	private Set comportes = new HashSet(0);

	public Jouet() {
	}

	public Jouet(String numero, Categorie categorie, Trancheage trancheage) {
		this.numero = numero;
		this.categorie = categorie;
		this.trancheage = trancheage;
	}

	public Jouet(String numero, Categorie categorie,
			Trancheage trancheage, String libelle, Set comportes) {
		this.numero = numero;
		this.categorie = categorie;
		this.trancheage = trancheage;
		this.libelle = libelle;
		this.comportes = comportes;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

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

	public Set getComportes() {
		return this.comportes;
	}

	public void setComportes(Set comportes) {
		this.comportes = comportes;
	}

}
