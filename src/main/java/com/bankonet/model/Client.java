package com.bankonet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
@DiscriminatorValue("C")
public class Client extends Personne {
  
	@Autowired
	@Embedded
	private Adresse adresse;
	@NotNull
	@Size(min=2,max=16)
	private String login;
	@NotNull
	@Size(min=6,max=50)//ne controle pas ce qui est dans la base,il  faut mettre @Column(length=4) par exemple
	//@Column(parametre)  pour ù
	private String motDePasse;
	
	@OneToMany
	private List<CompteCourant> listeComptesCourants=new ArrayList<CompteCourant>();
	@OneToMany
	private List<CompteEpargne> listeComptesEpargnes=new ArrayList<CompteEpargne>();
	public Client() {
		
	}
	
	
	
	public List<CompteCourant> getListeComptesCourants() {
		return listeComptesCourants;
	}



	public void setListeComptesCourants(List<CompteCourant> listeComptesCourants) {
		this.listeComptesCourants = listeComptesCourants;
	}



	public List<CompteEpargne> getListeComptesEpargnes() {
		return listeComptesEpargnes;
	}



	public void setListeComptesEpargnes(List<CompteEpargne> listeComptesEpargnes) {
		this.listeComptesEpargnes = listeComptesEpargnes;
	}



	public Client( String nom, String prenom, String login, String motDePasse, Adresse adresse) {
		super(nom,prenom);
		this.adresse = adresse;
		this.login = login;
		this.motDePasse = motDePasse;
	}



	public Client(String nom, String prenom, Adresse adresse) {
		super(prenom, nom);
		this.adresse=adresse;
	}


	@Override
	public String toString() {
		return super.toString()
				+ "\n login : "+this.login
				+ "\n mot de passe : "+this.motDePasse
				+ "\n adresse : "+this.adresse;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getMotDePasse() {
		return motDePasse;
	}




	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}




	
	
	
}
