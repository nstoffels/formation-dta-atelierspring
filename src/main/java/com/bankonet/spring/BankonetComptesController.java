/**
 * 
 */
package com.bankonet.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.metier.ICompteMetier;
import com.bankonet.model.Client;
import com.bankonet.model.CompteCourant;

/**
 * @author ETY
 *
 */
@Controller
@RequestMapping(value="/comptes")
public class BankonetComptesController {

	@Autowired
	private IBankonetMetier bankonetmetier;
	
	@Autowired
	private ICompteMetier comptemetier;
	/*
	 * 
	 * Constructeur
	 * 
	 */
	/**
	 * 
	 */
	public BankonetComptesController() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 
	 * Méthodes
	 * 
	 */
	@RequestMapping(value="/{idcli}/comptescourantsliste", method = RequestMethod.GET)
	public String index(Model model, @PathVariable("idcli") int idcli){
		
		Client c=bankonetmetier.editClient(idcli);
		model.addAttribute("client",bankonetmetier.editClient(idcli));
		model.addAttribute("comptecourant", new CompteCourant());
		model.addAttribute("comptes", comptemetier.listCompteclient(c));
		
		model.addAttribute("info", "vide");
		
		return "comptesview";
		
	}
	
	@RequestMapping(value="/{idcli}/saveCompte", method = RequestMethod.POST)
	public String saveClient(@Valid CompteCourant c, @PathVariable("idcli") int idcli, BindingResult bindingResult, Model  model) {
		
		Client client=bankonetmetier.editClient(idcli);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("comptes",  comptemetier.listeCompte());
			model.addAttribute("info", "vide");
			model.addAttribute("client",new Client());
			return  "clientsview"; 
		}
		
		System.out.println("************************Tentative d'une possible sauvegarde/modification*******************************");
		System.out.println("***************************"+c.getIdentifiant()+"******************************************");
		try{
			if(c.getIdentifiant()!=0){
				//update et edition du client.
				c.setClient(client);
				comptemetier.addCompte(c);
				model.addAttribute("info", "editer");
			}else{
				
				comptemetier.addCompte(c);
				c.setClient(client);
				System.out.println("Compte sauvegardé");
				model.addAttribute("info", "sauvegarde");
			}
			model.addAttribute("clients", bankonetmetier.listClients());
			model.addAttribute("client",bankonetmetier.editClient(idcli));
			return  "clientsview";
			
		}catch(Exception e){
			System.out.println("Sauvegarde impossible.");
			e.printStackTrace();
		}
		model.addAttribute("clients", bankonetmetier.listClients());
		model.addAttribute("client",bankonetmetier.editClient(idcli));
		return "clientsview";

	
	}

}
