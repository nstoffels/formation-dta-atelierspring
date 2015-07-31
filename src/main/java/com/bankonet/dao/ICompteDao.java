/**
 * 
 */
package com.bankonet.dao;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

/**
 * @author ETY
 *
 */
public interface ICompteDao {
	
	public void addCompte(Compte c);
	public void deleteCompte(int idCompte);
	public Compte editCompte(int idClompte);
	public void updateCompte(Compte c);
	public List<Compte> listeCompte();
	public List<Compte> listCompteclient(Client c);
	

}
