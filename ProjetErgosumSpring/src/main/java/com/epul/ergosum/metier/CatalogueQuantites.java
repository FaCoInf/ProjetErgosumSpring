package com.epul.ergosum.metier;

public class CatalogueQuantites {
	private String	id;
	private String	quantiteDistribuee;
	private String	quantite;
	private String	difference;

	public CatalogueQuantites(String id, String quantiteDistribuee, String quantite, String difference) {
		this.id = id;
		this.quantiteDistribuee = quantiteDistribuee;
		this.quantite = quantite;
		this.difference = difference;
	}

	public CatalogueQuantites() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuantiteDistribuee() {
		return quantiteDistribuee;
	}

	public void setQuantiteDistribuee(String quantiteDistribuee) {
		this.quantiteDistribuee = quantiteDistribuee;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getDifference() {
		return difference;
	}

	public void setDifference(String difference) {
		this.difference = difference;
	}

}
