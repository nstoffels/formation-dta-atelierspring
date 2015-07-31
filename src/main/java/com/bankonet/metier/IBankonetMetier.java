/**
 * 
 */
package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Client;

/**
 * @author Admin Stoffels
 *
 */

public interface IBankonetMetier {
	public void addClient(Client c); 
	public List<Client> listClients();
	public void deleteClient(int idClient);
	public Client editClient(int idClient);
	public void updateClient(Client c);
	public List<Client> chercherClients(String	motCle);
	public List<Client> SupprimerClientDontLeNomContient(String motCle);
}
