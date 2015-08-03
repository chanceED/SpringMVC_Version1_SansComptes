package com.bankonet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public  class CompteEpargne extends Compte {
	
    private float tauxInteret;
    private float plafond;
    
  //  private static int nombreComptesEpargnes = 0;

   
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompteEpargne(int id, String libelle, float solde) {
		super(id, libelle, solde);
		// TODO Auto-generated constructor stub
	}


	public CompteEpargne(String libelle, int identifiant, float solde,
			Client client) {
		super(libelle, identifiant, solde, client);
		// TODO Auto-generated constructor stub
	}


	public CompteEpargne(int id, String libelle, float solde, float tauxInteret, float plafond) {
        super(id, libelle, solde);
        this.tauxInteret = tauxInteret;
        this.plafond = plafond;
       
    }

   
    public boolean creditAutorise(float montant) throws BankonetException {
        if (montant+getSolde() < getPlafond()) {
            return true;
        } else {
            throw new BankonetException("Le compte epargne "+ this.getIdentifiant() + " a pour plafond de credit : " + this.getPlafond());
        }
    }

    public boolean debitAutorise(float montant) throws BankonetException {
        if (getSolde() - montant >= 0) {
            return true;
        } else {
            throw new BankonetException("Montant trop eleve : le solde du compte epargne "+ this.getIdentifiant() + " ne peut etre negatif" );
        }
    }


    public String toString() {
        return  super.toString()+
        		" - Taux interet : "+this.getTauxInteret()+" % "+
	    		" - Plafond : "+this.getPlafond();
    }

  
    public float getPlafond() {
        return plafond;
    }

  
    public void setPlafond(float newPlafond) {
        plafond = newPlafond;
    }

    
    public float getTauxInteret() {
        return tauxInteret;
    }

    
    public void setTauxInteret(float newTauxInteret) {
        tauxInteret = newTauxInteret;
    }
}