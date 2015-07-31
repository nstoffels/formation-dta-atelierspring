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
import com.bankonet.model.Client;

/**
 * @author ETY
 *
 */
@Controller
public class BankonetController {

	@Autowired
	private IBankonetMetier bankonetmetier;
		
	
	/**
	 * 
	 */
	public BankonetController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model){
		
		
		model.addAttribute("clients", bankonetmetier.listClients());
		model.addAttribute("client",new Client());
		model.addAttribute("info", "vide");
		
		return "clientsview";
		
	}
	
	/**
	 * 
	 * @param c
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/saveClient", method = RequestMethod.POST)
	public String saveClient(@Valid Client c, BindingResult bindingResult, Model  model) {

		if(bindingResult.hasErrors()) {
			model.addAttribute("clients",  bankonetmetier.listClients());
			model.addAttribute("info", "vide");
			return  "clientsview"; 
		}
		
		System.out.println("Tentative d'une possible sauvegarde/modification :");
		System.out.println("***************************"+c.getId()+"******************************************");
		try{
			if(c.getId()!=0){
				//update et edition du client.
				bankonetmetier.updateClient(c);
				model.addAttribute("info", "editer");
			}else{
				bankonetmetier.addClient(c);
				System.out.println("Client sauvegardé");
				model.addAttribute("info", "sauvegarde");
			}
			model.addAttribute("clients", bankonetmetier.listClients());
			return  "clientsview";
			
		}catch(Exception e){
			System.out.println("Sauvegarde impossible.");
			e.printStackTrace();
		}
		model.addAttribute("clients", bankonetmetier.listClients());
		return "clientsview";

	
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editclient/{id}", method = RequestMethod.GET)
	public String editCLient(@PathVariable("id") int id,Model model){
		
		model.addAttribute("client",bankonetmetier.editClient(id));
		model.addAttribute("clients", bankonetmetier.listClients());
		System.out.println("////////////////////////////////////////"+id+"///////////////////////////////////");
		model.addAttribute("info", "vide");
		return "clientsview";
		
	}
	
	@RequestMapping(value="/deleteclient/{id}", method = RequestMethod.GET)
	public String deleteClient(@PathVariable("id") int id,Model model){
		
		bankonetmetier.deleteClient(id);
		model.addAttribute("clients", bankonetmetier.listClients());
		model.addAttribute("client",new Client());
		System.out.println("--------------------------------"+id+"---------------------------------------");
		model.addAttribute("info", "supprimer");
		return "clientsview";
	}
	
}
