/**
 * 
 */
package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;

/**
 * @author Admin Stoffels
 *
 */
@Repository("clientdao")
public class ClientDaoImpl implements IClientDao {

	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager em;
	
	
	public ClientDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.IClientDao#addClient(com.bankonet.model.Client)
	 */	
	@Transactional(propagation=Propagation.MANDATORY)
	public void addClient(Client c) {
		// TODO Auto-generated method stub
		System.out.println("client ajout� : "+c.toString());
		em.persist(c);
		
	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.IClientDao#listClients()
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Client> listClients() {
		// TODO Auto-generated method stub
		
		Query req=em.createQuery("select c from Client c order by c.id");
		System.out.println("liste client : " + req.getResultList());
		return req.getResultList();
		
	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.IClientDao#deleteClient(int)
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public void deleteClient(int idClient) {
		// TODO Auto-generated method stub
		
		Client c=em.find(Client.class, idClient);
		System.out.println("client "+c+" Supprimé !" );
		em.remove(c);
		// ou em.remove(idClient);
		
	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.IClientDao#editClient(int)
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public Client editClient(int idClient) {
		// TODO Auto-generated method stub
		
		Client client=em.find(Client.class, idClient);
		System.out.println("client "+client+"récupéré, prêt à être édité");
		//em.merge(client);
		return client;
	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.IClientDao#updateClient(com.bankonet.model.Client)
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public void updateClient(Client c) {
		// TODO Auto-generated method stub
		System.out.println("client "+c+" Mis à Jours");
		//Client client=em.find(Client.class, c);
		em.merge(c);
		
	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.IClientDao#chercherClients(java.lang.String)
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Client> chercherClients(String motCle) {
		// TODO Auto-generated method stub
		
		Query req=em.createQuery("select c from Client c where c.nom like :x or c.prenom like :x");
		req.setParameter("x", "%"+motCle+"%");
		System.out.println("Le client "+req.getResultList()+" a �t� trouv�");
		return req.getResultList();
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	

}
