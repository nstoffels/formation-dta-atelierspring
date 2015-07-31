/**
 * 
 */
package com.bankonet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

/**
 * @author ETY
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Personne {
	@Id
	@GeneratedValue
	private int id;


	@Size(min=3, max=60)
	public String nom ;
	@Size(min=3, max=60)
	public String prenom;
	/**
	 * 
	 */
	public Personne() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nom
	 * @param prenom
	 */
	public Personne(String nom, String prenom) {

		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * @param id
	 */
	public Personne(int id) {
		super();
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * 
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}






}
