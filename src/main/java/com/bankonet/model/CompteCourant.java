package com.bankonet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	
    private float decouvertAutorise;
  //  public static int nombreComptesCourants = 0;
 

	public CompteCourant(String libelle, int identifiant, float solde,
			Client client) {
		super(libelle, identifiant, solde, client);
		// TODO Auto-generated constructor stub
	}




	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompteCourant(int id, String libelle, float solde) {
		super(id, libelle, solde);
		// TODO Auto-generated constructor stub
	}


	public CompteCourant(float decouvertAutorise) {
	super();
	this.decouvertAutorise = decouvertAutorise;
}


	public CompteCourant(int id, String libelle, float solde, float decouvertAutorise) {

        super(id, libelle, solde);

        this.decouvertAutorise = decouvertAutorise;
       
    }

  
    public boolean creditAutorise(float montant) throws BankonetException {
        return true;
    }

    public boolean debitAutorise(float montant) throws BankonetException {
        if (this.getSolde() + this.getDecouvertAutorise() >= montant) {
            return true;
        } else {
            throw new BankonetException("Montant trop eleve : le solde du compte courant "+ this.getIdentifiant() + " ne peut descendre en dessous du decouvert autorise" );
        }
    }

  
    public float getDecouvertAutorise() {
        return decouvertAutorise;
    }
    
    public String toString() {
        return   super.toString()+
	    		" - Découvert autorisé : "+this.getDecouvertAutorise()+" €";
    }
}