/**
 * 
 */
package com.bankonet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankonet.model.Adresse;
import com.bankonet.model.Client;

/**
 * @author ETY
 *
 */
@Repository("clientdaojpa")
public interface IClientDaoJpaRepository extends JpaRepository<Client, Long> {
	
	List<Client> findByNomOrPrenom(String nom, String prenom);
	
	List<Client> findById(int id);
	
	List<Client> findByAdresse(Adresse adresse);
	
	List<Client> findByLoginOrMotDePasse(String login, String motDePasse);
 	
	List<Client> findAll();
	 
	
}
