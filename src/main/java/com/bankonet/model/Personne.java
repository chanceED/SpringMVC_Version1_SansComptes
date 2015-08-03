package com.bankonet.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name = "TYPE")
public abstract class Personne {

	
	@Id @GeneratedValue
	private int id;
	@NotNull
	@Size(min=3,max=60)
	private String nom;
	@Size(min=3,max=60)
	private String prenom;
	
	
	public Personne( String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "id=" + this.id 
				+ "\n nom :" + this.nom 
				+ "\n prenom :" + this.prenom;
	}
	

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
	
	
	
}
