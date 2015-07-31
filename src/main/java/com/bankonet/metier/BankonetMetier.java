/**
 * 
 */
package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.IClientDao;
import com.bankonet.model.Client;

/**
 * @author Admin Stoffels
 *
 */
@Service("bankonetmetier") 
public class BankonetMetier implements IBankonetMetier {

	@Resource(name="clientdao")
	public IClientDao clientdao;
	
	/**
	 * 
	 */
	public BankonetMetier() {
		// TODO Auto-generated constructor stub
		
	}
	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public void addClient(Client c) {
		// TODO Auto-generated method stub
		clientdao.addClient(c);
		//throw new RuntimeException("Erreur runtime/unchecked!");
	}
	@Transactional(readOnly=true)
	public List<Client> listClients() {
		// TODO Auto-generated method stub
		return clientdao.listClients();
	}
	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public void deleteClient(int idClient) {
		// TODO Auto-generated method stub
		clientdao.deleteClient(idClient);
	}
	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public Client editClient(int idClient) {
		// TODO Auto-generated method stub
		
		return clientdao.editClient(idClient);
	}
	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public void updateClient(Client c) {
		// TODO Auto-generated method stub
		clientdao.updateClient(c);
	}

	@Transactional(readOnly=true)
	public List<Client> chercherClients(String motCle) {
		// TODO Auto-generated method stub
		
		return clientdao.chercherClients(motCle);
	}
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Client> SupprimerClientDontLeNomContient(String motCle){
		
		for(Client client : clientdao.chercherClients(motCle)){
			clientdao.deleteClient(client.getId());
		}
		return listClients();
		
	}

	/**
	 * @return the clientdao
	 */
	public IClientDao getClientdao() {
		return clientdao;
	}

	/**
	 * @param clientdao the clientdao to set
	 */
	public void setClientdao(IClientDao clientdao) {
		this.clientdao = clientdao;
	}
	
	
}
