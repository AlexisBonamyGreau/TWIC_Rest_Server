package com.dto;

import java.io.Serializable;

public class Ville implements Serializable {
	
	private String code_insee;
	private String nom;
	private String code_postal;
	private String libelle;
	private String ligne;
	private String latitude;
	private String longitude;
	
	
	public String getCode_insee() {
		return code_insee;
	}
	public void setCode_insee(String code_insee) {
		this.code_insee = code_insee;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLigne() {
		return ligne;
	}
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
