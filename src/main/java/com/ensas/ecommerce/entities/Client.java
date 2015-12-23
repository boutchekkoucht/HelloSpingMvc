package com.ensas.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Client implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int id;
	private String  nom;
	private String prenom;
	private  String email;
	private String  motpasse;
	private double solde;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotpasse() {
		return motpasse;
	}
	public void setMotpasse(String motpasse) {
		this.motpasse = motpasse;
	}
	
	
	
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	
	
	

}
