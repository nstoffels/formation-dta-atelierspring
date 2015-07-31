package com.bankonet.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * @author Neobject
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typecompte")
public abstract class Compte {

	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private int identifiant;
	
	private String libelle;
	protected float solde;

	private Client client;
	
	
	/**
	 * Constructeur standard.
	 */
	Compte(int id, String libelle, float solde) {

		this.identifiant = id;
		this.libelle = libelle;
		this.solde = solde;

	}
	Compte() {

	}
	
	/**
	 * @param libelle
	 * @param solde
	 * @param client
	 */
	public Compte(String libelle, float solde, Client client) {
		super();
		this.libelle = libelle;
		this.solde = solde;
		this.client = client;
	}
	
	
	
	public abstract boolean creditAutorise(float montant) throws BankonetException;


	public abstract boolean debitAutorise(float montant) throws BankonetException;

	
	
	/*
	 * 
	 * Getters et Setters
	 * 
	 */
	public String getLibelle() {
		return libelle;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float newSolde) {
		this.solde = newSolde;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
