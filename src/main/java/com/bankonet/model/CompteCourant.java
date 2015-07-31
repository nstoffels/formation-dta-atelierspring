package com.bankonet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;


/**
 */
@Entity
@DiscriminatorValue("Cp")
@Component("comptecourant")
public class CompteCourant extends Compte {
    private float decouvertAutorise;
    
    /*
     * 
     * 
     * Constructeurs
     * 
     */
    /**
     * 
     * @param id
     * @param libelle
     * @param solde
     * @param decouvertAutorise
     */
    public CompteCourant(int id, String libelle, float solde,
            float decouvertAutorise) {

        super(id, libelle, solde);

        this.decouvertAutorise = decouvertAutorise;
    }
    
    

	/**
	 * @param id
	 * @param libelle
	 * @param solde
	 */
	public CompteCourant(int id, String libelle, float solde) {
		super(id, libelle, solde);
	}
	
	
	public CompteCourant(){
		
	}

	/*
	 * 
	 * Méthodes
	 * 
	 * 
	 */
	/**
     * Le credit d'un compte courant est toujours autorise
     */
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
    
    
    /*
     * 
     * getter et setter
     * 
     * 
     */
    /**
     * Accesseur de la propriete <code>decouvertAutorise</code>.
     * 
     * @return float
     */
    public float getDecouvertAutorise() {
        return decouvertAutorise;
    }



	/**
	 * @param decouvertAutorise the decouvertAutorise to set
	 */
	public void setDecouvertAutorise(float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}
    
    
    
}