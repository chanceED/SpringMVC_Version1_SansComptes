package com.bankonet.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typecompte")
public abstract class Compte   {
	
	@Id @GeneratedValue
	private int identifiant;

	private String libelle;
	protected float solde;
	
    private Client client;
    
    
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	Compte(int id, String libelle, float solde) {

		this.identifiant = id;
		this.libelle = libelle;
		this.solde = solde;

	}

	public float getSolde() {
		return solde;
	}


	public Compte(String libelle, int identifiant, float solde, Client client) {
		super();
		this.libelle = libelle;
		this.identifiant = identifiant;
		this.solde = solde;
		this.client = client;
	}

	public abstract boolean creditAutorise(float montant) throws BankonetException;

	public abstract boolean debitAutorise(float montant) throws BankonetException;

	public String toString() {
		
	        return  " ID  : "+this.getIdentifiant() +" - "+
		    		" Lib : "+this.getLibelle()+" - "+
		    		" Solde : "+this.getSolde()+"€";
	    
	}
	
	public String getLibelle() {
		return libelle;
	}

	public int getIdentifiant() {
		return identifiant;
	}


	public void setSolde(float newSolde) {
		this.solde = newSolde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	
}
