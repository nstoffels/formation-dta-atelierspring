/**
 * 
 */
package com.bankonet.model;

import javax.persistence.Embeddable;

/**
 * @author ETY
 *
 */
@Embeddable
public class Adresse {
	
	
	int numero;
	String rue;
	String ville;
	
	/*
	 * 
	 * génération des constructeurs
	 * 
	 */
	
	/**
	 * 
	 */
	public Adresse() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param numero
	 * @param rue
	 * @param ville
	 */
	public Adresse(int numero, String rue, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		
		
	}
	
	/*
	 * méthode
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "numero : "+this.getNumero() + " ; " + " rue : "+this.getRue() + " ; " + " ville : " + this.getVille();
	}
	
	/*
	 * 
	 * Génération des getters/setters
	 * 
	 */
	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
