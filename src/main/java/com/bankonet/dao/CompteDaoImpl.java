/**
 * 
 */
package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

/**
 * @author ETY
 *
 */
@Repository("comptedao")
public class CompteDaoImpl implements ICompteDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * 
	 * Constructeur
	 * 
	 */
	/**
	 * 
	 */
	public CompteDaoImpl() {
		// TODO Auto-generated constructor stub
	}


	/*
	 * 
	 * 
	 * Méthodes
	 * 
	 */
	/* (non-Javadoc)
	 * @see com.bankonet.dao.ICompteDao#addCompte(com.bankonet.model.Compte)
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public void addCompte(Compte c) {
		// TODO Auto-generated method stub
		em.persist(c);
	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.ICompteDao#deleteCompte(int)
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public void deleteCompte(int idCompte) {
		// TODO Auto-generated method stub
		Compte c=em.find(Compte.class, idCompte);
		em.remove(c);

	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.ICompteDao#listeCompte()
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Compte> listeCompte() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select c from Compte as c");
		System.out.println("liste compte : " + req.getResultList());
		return req.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see com.bankonet.dao.ICompteDao#listeCompteclient()
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Compte> listCompteclient(Client c) {  
//
		TypedQuery<Compte> selectQuery = em.createQuery("select compte FROM Compte as compte where compte.client = :x",Compte.class);  
		selectQuery.setParameter("x", c);  

		return (List<Compte>)selectQuery.getResultList();  
//		return null;
		
	}  

	@Override
	public Compte editCompte(int idCompte) {
		// TODO Auto-generated method stub
		Compte compte = em.find(Compte.class, idCompte);
		return compte;
	}


	@Override
	public void updateCompte(Compte c) {
		// TODO Auto-generated method stub
		Compte compte = em.find(Compte.class, c.getIdentifiant());
		if(compte!=null){
					
			em.merge(c);
		
		}else {
			System.out.println("Compte inexistant");
		}
	}

	/*
	 * 
	 * génération des getters et setters
	 * 
	 */
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
