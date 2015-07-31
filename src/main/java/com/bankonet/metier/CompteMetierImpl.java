/**
 * 
 */
package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.ICompteDao;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;

/**
 * @author ETY
 *
 */
@Service("comptemetier")
public class CompteMetierImpl implements ICompteMetier {
	
	@Resource(name="comptedao")
	public ICompteDao comptedao;
	
	/*
	 * 
	 * Constructeur par défaut
	 * 
	 */
	/**
	 * 
	 */
	public CompteMetierImpl() {
		// TODO Auto-generated constructor stub
	}

	
		
	/*
	 * 
	 * Méthodes
	 * 
	 */
	/* (non-Javadoc)
	 * @see com.bankonet.metier.ICompteMetier#virement(float, int)
	 */
	@Override
	public void virement(float solde, int idCompte) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.bankonet.metier.ICompteMetier#addCompte(com.bankonet.model.Compte)
	 */
	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public void addCompte(Compte c) {
		// TODO Auto-generated method stub
		
		comptedao.addCompte(c);

	}

	/* (non-Javadoc)
	 * @see com.bankonet.metier.ICompteMetier#deleteCompte(int)
	 */
	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public void deleteCompte(int idCompte) {
		// TODO Auto-generated method stub
		//Compte cc = comptedao.editCompte(idCompte);
		comptedao.deleteCompte(idCompte);

	}

	/* (non-Javadoc)
	 * @see com.bankonet.metier.ICompteMetier#listeCompte()
	 */
	@Transactional(readOnly=true)
	public List<Compte> listeCompte() {
		// TODO Auto-generated method stub
		return comptedao.listeCompte();
	}
		
	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public List<Compte> listCompteclient(Client c) {
		// TODO Auto-generated method stub
		
		return comptedao.listCompteclient(c);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public Compte editCompte(int idClompte) {
		// TODO Auto-generated method stub
		return comptedao.editCompte(idClompte);
	}



	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public void updateCompte(Compte c) {
		// TODO Auto-generated method stub
		comptedao.updateCompte(c);
		
	}
	
	/*
	 * 
	 * Getters et setter
	 * 
	 */
	
	/**
	 * @return the comptedao
	 */
	public ICompteDao getComptedao() {
		return comptedao;
	}



	/**
	 * @param comptedao the comptedao to set
	 */
	public void setComptedao(ICompteDao comptedao) {
		this.comptedao = comptedao;
	}

	
}
